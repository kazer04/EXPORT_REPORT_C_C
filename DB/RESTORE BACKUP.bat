@color 2
@echo WELCOME to BACKUP TOOL export_report_cc_db
@echo **********************************************

mysql -h localhost -u root -p  export_report_cc_db < export_report_cc_db.sql

@pause