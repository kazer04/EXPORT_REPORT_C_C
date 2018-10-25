@echo WELCOME to DO BACKUP TOOL export_report_cc_db
mysqldump -u root -h localhost -padmin export_report_cc_db --routines > export_report_cc_db.sql 
@PAUSE