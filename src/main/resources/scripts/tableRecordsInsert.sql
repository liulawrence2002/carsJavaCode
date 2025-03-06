create schema cars

SET IDENTITY_INSERT cars.[application_status] ON
if not exists (Select * from cars.[application_status])
Begin
INSERT INTO cars.[application_status]
           ([active]
           ,id
           ,[application_status_description]
           ,[application_status_name])
	SELECT [Active]
			,[ApplicationStatusId]
		  ,[ApplicationStatusDescription]
		  ,[ApplicationStatusName]
	 FROM [ARS-Test].[dbo].[ApplicationStatus]
 End
 SET IDENTITY_INSERT cars.[application_status] OFF

SET IDENTITY_INSERT cars.[client] ON
if not exists (Select * from cars.[client])
Begin
 INSERT INTO [cars].[client]
           (id,[client_host_port],[tenant_id],[client_abrv],[client_desc],[client_host_domain],[client_host_subdomain])
	SELECT ClientID,[ClientHostPort],[TenantId],[ClientAbrv],[ClientDesc],[ClientHostDomain],[ClientHostSubdomain]
	FROM [ARS-Test].[dbo].[Client]
end
SET IDENTITY_INSERT cars.[client] OFF

SET IDENTITY_INSERT cars.client_award_type ON
if not exists (Select * from cars.client_award_type)
Begin
INSERT INTO cars.client_award_type
           (id,[active]      ,[client_id]           ,[created_by]           ,[deleted_by]           ,[deleted_flag]
           ,[last_updated_by]           ,[tenant_id]           ,[date_created]           ,[deleted_date]
           ,[last_updated]           ,[award_abbreviation]           ,[award_description]           ,[detailed_description])
SELECT ClientAwardTypeId, [active]           ,[clientid]           ,[createdby]           ,[deletedby]           ,[deletedflag]
           ,[ModifiedBy]           ,[tenantid]           ,getdate()           ,[deleteddate]           ,getdate()
           ,[awardabbreviation]           ,[awarddescription]           ,[detaileddescription]
  FROM [ARS-Test].[dbo].[ClientAwardType]
END
SET IDENTITY_INSERT cars.client_award_type OFF

SET IDENTITY_INSERT cars.[client_cycle] ON
if not exists (Select * from cars.[client_cycle])
Begin
INSERT INTO [cars].[client_cycle]
           (id,[active]           ,[client_id]           ,[created_by]           ,[deleted_by]           ,[deleted_flag]
           ,[last_updated_by]           ,[tenant_id]           ,[date_created]           ,[deleted_date]
           ,[last_updated]           ,[cycle_name])
SELECT ClientCycleId, [active]           ,[clientid]           ,[createdby]           ,[deletedby]           ,[deletedflag]
           ,[modifiedby]           ,[tenantid]           ,getdate()           ,[deleteddate]
           ,getdate()           ,[cyclename]
  FROM [ARS-Test].[dbo].[ClientCycle]
end
SET IDENTITY_INSERT cars.[client_cycle] OFF

SET IDENTITY_INSERT cars.[org_class] ON
if not exists (Select * from cars.[org_class])
Begin
INSERT INTO [cars].[org_class]
           (id,[org_class_name])
SELECT OrgClassId, [orgclassname]
  FROM [ARS-Test].[dbo].[orgclass]
End
SET IDENTITY_INSERT cars.[org_class] OFF

SET IDENTITY_INSERT cars.[tenant_type] ON
if not exists (Select * from cars.[tenant_type])
Begin
INSERT INTO [cars].[tenant_type]
           ([id]           ,[tenant_type_name])
SELECT  [tenanttypeid]           ,[tenanttypename]
  FROM [ARS-Test].[dbo].[tenanttype]
End
SET IDENTITY_INSERT cars.[tenant_type] OFF

SET IDENTITY_INSERT cars.[tenant] ON
if not exists (Select * from cars.[tenant])
Begin
INSERT INTO [cars].[tenant]
           (id,[tenant_type_id]           ,[tenantguid]           ,[tenant_name])
SELECT TenantId, [tenanttypeid]           ,[tenantguid]           ,[tenantname]
  FROM [ARS-Test].[dbo].[tenant]
End
SET IDENTITY_INSERT cars.[tenant] OFF

SET IDENTITY_INSERT cars.[client_org_class] ON
if not exists (Select * from cars.[client_org_class])
Begin
INSERT INTO [cars].[client_org_class]
           (id,[client_id]           ,[created_by]           ,[deleted_by]           ,[deleted_flag]           ,[last_updated_by]           ,[org_class_id]           ,[tenant_id]
           ,[date_created]           ,[deleted_date]           ,[last_updated]           ,[client_spec_name]           ,[description])
SELECT ClientOrgClassId, [clientid]           ,[createdby]           ,[deletedby]           ,[deletedflag]           ,[ModifiedBy]           ,[orgclassid]           ,[tenantid]
           ,getdate()           ,[deleteddate]           ,getdate()           ,[clientspecname]           ,[description]
  FROM [ARS-Test].[dbo].[clientorgclass]
End
SET IDENTITY_INSERT cars.[client_org_class] OFF

SET IDENTITY_INSERT cars.[org_type] ON
if not exists (Select * from cars.[org_type])
Begin
INSERT INTO [cars].[org_type]
           (id,[org_type_name])
SELECT OrgTypeId, [orgtypename]
  FROM [ARS-Test].[dbo].[orgtype]
End
SET IDENTITY_INSERT cars.[org_type] OFF

SET IDENTITY_INSERT cars.[client_org_type] ON
if not exists (Select * from cars.[client_org_type])
Begin
INSERT INTO [cars].[client_org_type]
           (id,[client_id]           ,[created_by]           ,[deleted_by]           ,[deleted_flag]           ,[last_updated_by]           ,[org_type_id]           ,[tenant_id]
           ,[date_created]           ,[deleted_date]           ,[last_updated]           ,[client_spec_name]           ,[description])
SELECT ClientOrgTypeId, [clientid]           ,[createdby]           ,[deletedby]           ,[deletedflag]           ,[ModifiedBy]           ,[orgtypeid]           ,[tenantid]
           ,getdate()           ,[deleteddate]           ,getdate()           ,[clientspecname]           ,[description]
  FROM [ARS-Test].[dbo].[clientorgtype]
End
SET IDENTITY_INSERT cars.[client_org_type] OFF

SET IDENTITY_INSERT cars.[client_program] ON
if not exists (Select * from cars.[client_program])
Begin
INSERT INTO [cars].[client_program]
           (id,[active]           ,[client_id]           ,[created_by]           ,[deleted_by]           ,[deleted_flag]           ,[last_updated_by]           ,[tenant_id]           ,[date_created]
           ,[deleted_date]           ,[last_updated]           ,[program_prefix]           ,[legacy_program_id]           ,[program_abbreviation]           ,[short_description]
           ,[program_description]           ,[detailed_description])
SELECT ClientProgramId, [active]           ,[clientid]           ,[createdby]           ,[deletedby]           ,[deletedflag]           ,[modifiedby]           ,[tenantid]           ,getdate() 
           ,[deleteddate]           ,getdate()            ,[programprefix]           ,[legacyprogramid]           ,[programabbreviation]           ,[shortdescription]
           ,[programdescription]           ,[detaileddescription]
  FROM [ARS-Test].[dbo].[clientprogram]
End
SET IDENTITY_INSERT cars.[client_program] OFF

SET IDENTITY_INSERT cars.[funding_opportunity_status] ON
if not exists (Select * from cars.[funding_opportunity_status])
Begin
INSERT INTO [cars].[funding_opportunity_status]
           ([active]           ,[id]           ,[funding_opportunity_status_description]           ,[funding_opportunity_status_name])
SELECT TOP (1000) [active]           ,[fundingopportunitystatusid]           ,[fundingopportunitystatusdescription]           ,[fundingopportunitystatusname]
  FROM [ARS-Test].[dbo].[fundingopportunitystatus]
End
SET IDENTITY_INSERT cars.[funding_opportunity_status] OFF


SET IDENTITY_INSERT cars.[organization] ON
if not exists (Select * from cars.[organization])
Begin
INSERT INTO [cars].[organization]
           (id,[active]           ,[client_id]           ,[client_org_class_id]           ,[client_org_type_id]           ,[created_by]           ,[deleted_by]           ,[deleted_flag]           ,[fyclose_day]
           ,[fyclose_month]           ,[last_updated_by]           ,[tenant_id]           ,[date_created]           ,[deleted_date]           ,[last_updated]           ,[ein]           ,[duns]
           ,[org_short_name]           ,[vendor_number]           ,[organization_name])
SELECT id, [active]           ,[clientid]           ,[clientorgclassid]           ,[clientorgtypeid]           ,[createdby]           ,[deletedby]           ,[deletedflag]           ,[fycloseday]
           ,[fyclosemonth]           ,[ModifiedBy]           ,[tenantid]           ,getdate()           ,[deleteddate]           ,getdate()           ,[ein]           ,[duns]
           ,[orgshortname]           ,[vendornumber]           ,[organizationname]
  FROM [ARS-Test].[dbo].[organization]
End
SET IDENTITY_INSERT cars.[organization] OFF

SET IDENTITY_INSERT cars.[pro_user] ON
if not exists (Select * from cars.[pro_user])
Begin
INSERT INTO [cars].[pro_user]
           (id,[created_by]           ,[credential_sent_by]           ,[deleted_by]           ,[deleted_flag]           ,[is_activated]           ,[is_locked_out]           ,[last_updated_by]           ,[personid]
           ,[tenant_id]           ,[verified]           ,[w9verified]           ,[credential_sent_date]           ,[date_created]           ,[deleted_date]           ,[last_locked_out_date]           ,[last_login_date]
           ,[last_updated]           ,[new_email_requested]           ,[new_password_requested]           ,[password_date]           ,[verified_date]           ,[w9verified_date]           ,[new_email]
           ,[user_login]           ,[password]           ,[password_salt])
SELECT UserID,[createdby]           ,[credentialsentby]           ,[deletedby]           ,[deletedflag]           ,[isactivated]           ,[islockedout]           ,[modifiedby]           ,[personid]
           ,[tenantid]           ,[verified]           ,[w9verified]           ,[credentialsentdate]           ,getdate()           ,[deleteddate]           ,[lastlockedoutdate]           ,[lastlogindate]
           ,getdate()           ,[newemailrequested]           ,[newpasswordrequested]           ,[passworddate]           ,[verifieddate]           ,[w9verifieddate]           ,[newemail]
           ,[userlogin]           ,[password]           ,[passwordsalt]
  FROM [ARS-Test].[dbo].[user]
End
SET IDENTITY_INSERT cars.[pro_user] OFF

SET IDENTITY_INSERT cars.[program_year] ON
if not exists (Select * from cars.[program_year])
Begin
INSERT INTO [cars].[program_year]
           (id,[client_program_id]           ,[created_by]           ,[deleted_by]           ,[deleted_flag]           ,[last_updated_by]           ,[legacy_program_id]           ,[tenant_id]
           ,[date_closed]           ,[date_created]           ,[deleted_date]           ,[last_updated]           ,[year])
SELECT ProgramYearId,[clientprogramid],[createdby]           ,[deletedby]           ,[deletedflag]           ,[modifiedby]           ,[legacyprogramid]           ,[tenantid]
           ,[dateclosed]           ,getdate()            ,[deleteddate]           ,getdate()            ,[year]
  FROM [ARS-Test].[dbo].[programyear]
End
SET IDENTITY_INSERT cars.[program_year] OFF

SET IDENTITY_INSERT cars.[program_mechanism] ON
if not exists (Select * from cars.[program_mechanism])
Begin
INSERT INTO [cars].[program_mechanism]
           (id,       [blinded_flag]           ,[client_award_type_id]           ,[client_cycle_id]           ,[created_by]           ,[deleted_by]           ,[deleted_flag]           ,[funding_opportunity_status_id]
		   ,[last_updated_by]           ,[partnering_pi_allowed_flag]           ,[program_year_id]           ,[tenant_id]           ,[date_created]           ,[deleted_date]           ,[last_updated]
           ,[funding_opportunity_abbreviation]           ,[funding_opportunity_description]           ,[funding_opportunity_title])
SELECT ProgramMechanismId, [blindedflag]           ,[clientawardtypeid]           ,[clientcycleid]           ,[createdby]           ,[deletedby]           ,[deletedflag]           ,[fundingopportunitystatusid]
		   ,[modifiedby]           ,[partneringpiallowedflag]           ,[programyearid],               [tenantid]           ,getdate()           ,[deleteddate]           ,getdate()
           ,[fundingopportunityabbreviation]           ,[fundingopportunitydescription]           ,[fundingopportunitytitle]
  FROM [ARS-Test].[dbo].[programmechanism] 
End
SET IDENTITY_INSERT cars.[program_mechanism] OFF

SET IDENTITY_INSERT cars.[user_client] ON
if not exists (Select * from cars.[user_client])
Begin
INSERT INTO [cars].[user_client]
           (id,[clientid]           ,[created_by]           ,[deleted_by]           ,[deleted_flag]           ,[last_updated_by]           ,[tenant_id]           ,[userid]
           ,[created_date]           ,[deleted_date]           ,[last_updated])
SELECT UserClientID, [clientid]           ,[createdby]           ,[deletedby]           ,[deletedflag]           ,[modifiedby]           ,[tenantid]           ,[userid]
           ,getdate()           ,[deleteddate]           ,getdate()
  FROM [ARS-Test].[dbo].[userclient]
End
SET IDENTITY_INSERT cars.[user_client] OFF

---delete from cars.[user_client]
if not exists (Select * from cars.[user_info])
Begin
SET IDENTITY_INSERT cars.[user_info] ON
INSERT INTO [cars].[user_info]
           (id, [academic_rank_id]           ,[created_by]           ,[degree_not_applicable]           ,[deleted_by]           ,[deleted_flag]           ,[ethnicity_id]           ,[ethnicityarsid]           ,[gender_id]
           ,[military_rank_id]           ,[military_status_type_id]           ,[last_updated_by]           ,[prefix_id]           ,[professional_affiliation_id]           ,[tenant_id]           ,[userid]
		   ,[vendor_id]           ,[date_created]           ,[deleted_date]           ,[last_updated]           ,[first_name]           ,[middle_name]           ,[nick_name]           ,[suffix_text]
		   ,[badge_name]           ,[department]           ,[institution]           ,[last_name]           ,[position]           ,[vendor_name]           ,[expertise])
SELECT  userinfoid, [academicrankid]           ,[createdby]           ,[degreenotapplicable]           ,[deletedby]           ,[deletedflag]           ,[ethnicityid]           ,[ethnicityarsid]           ,[genderid]
           ,[militaryrankid]           ,[militarystatustypeid]           ,[modifiedby]           ,[prefixid]           ,[professionalaffiliationid]           ,[tenantid]           ,[userid]
		   ,[vendorid]           ,getdate()           ,[deleteddate]           ,getdate()           ,[firstname]           ,[middlename]           ,[nickname]           ,[suffixtext]
		   ,[badgename]           ,[department]           ,[institution]           ,[lastname]           ,[position]           ,[vendorname]           ,[expertise]
  FROM [ARS-Test].[dbo].[userinfo]
SET IDENTITY_INSERT cars.[user_info] OFF
End

if not exists (Select * from cars.[user_organization])
Begin
SET IDENTITY_INSERT cars.[user_organization] ON
INSERT INTO [cars].[user_organization]
           (id,[created_by]           ,[deleted_by]           ,[deleted_flag]           ,[last_updated_by]           ,[tenant_id]           ,[user_info_id]
           ,[user_org_id]           ,[date_created]           ,[deleted_date]           ,[last_updated])
SELECT  [Id],[createdby]           ,[deletedby]           ,[deletedflag]           ,[ModifiedBy]           ,[tenantid]           ,[userinfoid]
           ,[userorgid],                getdate()           ,[deleteddate]           ,getdate()
  FROM [ARS-Test].[dbo].[userorganization] order by UserInfoId asc
SET IDENTITY_INSERT cars.[user_organization] OFF
End
