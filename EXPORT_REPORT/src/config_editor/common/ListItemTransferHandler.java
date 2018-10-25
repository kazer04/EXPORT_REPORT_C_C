/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config_editor.common;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.activation.*;
import javax.swing.*;

/**
 *
 * @author HP PC
 */
public class ListItemTransferHandler extends TransferHandler {
    private final DataFlavor localObjectFlavor;
    private JList<?> source;
    private int[] indices;
    private int addIndex = -1; //Location where items were added
    private int addCount; //Number of items added.

    public ListItemTransferHandler() {
        super();
        localObjectFlavor = new ActivationDataFlavor(Object[].class, DataFlavor.javaJVMLocalObjectMimeType, "Array of items");
    }
    @Override protected Transferable createTransferable(JComponent c) {
        source = (JList<?>) c;
        indices = source.getSelectedIndices();
        Object[] transferedObjects = source.getSelectedValuesList().toArray(new Object[0]);
        return new DataHandler(transferedObjects, localObjectFlavor.getMimeType());
    }
    @Override public boolean canImport(TransferHandler.TransferSupport info) {
        return info.isDrop() && info.isDataFlavorSupported(localObjectFlavor);
    }
    @Override public int getSourceActions(JComponent c) {
        return TransferHandler.MOVE; //TransferHandler.COPY_OR_MOVE;
    }
    @SuppressWarnings("unchecked")
    @Override public boolean importData(TransferHandler.TransferSupport info) {
        if (!canImport(info)) {
            return false;
        }
        TransferHandler.DropLocation tdl = info.getDropLocation();
        if (!(tdl instanceof JList.DropLocation)) {
            return false;
        }
        JList.DropLocation dl = (JList.DropLocation) tdl;
        JList target = (JList) info.getComponent();
        DefaultListModel listModel = (DefaultListModel) target.getModel();
        int index = dl.getIndex();
        //boolean insert = dl.isInsert();
        int max = listModel.getSize();
        if (index < 0 || index > max) {
            index = max;
        }
        addIndex = index;

        try {
            Object[] values = (Object[]) info.getTransferable().getTransferData(localObjectFlavor);
            for (int i = 0; i < values.length; i++) {
                int idx = index++;
                listModel.add(idx, values[i]);
                target.addSelectionInterval(idx, idx);
            }
            addCount = target.equals(source) ? values.length : 0;
            return true;
        } catch (UnsupportedFlavorException | IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    @Override protected void exportDone(JComponent c, Transferable data, int action) {
        cleanup(c, action == TransferHandler.MOVE);
    }
    private void cleanup(JComponent c, boolean remove) {
        if (remove && indices != null) {
            //If we are moving items around in the same list, we
            //need to adjust the indices accordingly, since those
            //after the insertion point have moved.
            if (addCount > 0) {
                for (int i = 0; i < indices.length; i++) {
                    if (indices[i] >= addIndex) {
                        indices[i] += addCount;
                    }
                }
            }
            JList source = (JList) c;
            DefaultListModel model = (DefaultListModel) source.getModel();
            for (int i = indices.length - 1; i >= 0; i--) {
                model.remove(indices[i]);
            }
        }
        indices  = null;
        addCount = 0;
        addIndex = -1;
    }
}
