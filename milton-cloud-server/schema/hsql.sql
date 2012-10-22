alter table access_log drop constraint FKBBF335E9C4027D76;
alter table access_log drop constraint FKBBF335E91D457434;
alter table address_book drop constraint FKFB8B0542CB36CA7;
alter table app_control drop constraint FKEE00D53FC4027D76;
alter table app_control drop constraint FKEE00D53F1CD5CA34;
alter table app_control drop constraint FKEE00D53F849B88AA;
alter table app_setting drop constraint FK2BA87E323BD6907C;
alter table base_email_job drop constraint FK2F3D58ACC4027D76;
alter table branch drop constraint FKADAF25A2EDBCEC59;
alter table branch drop constraint FKADAF25A2A0FA3AD6;
alter table branch drop constraint FKADAF25A2DE9B19E5;
alter table cal_event drop constraint FKABCCC2E9C9A2A33E;
alter table cal_event_process drop constraint FK68508F19CBDEA377;
alter table cal_event_process drop constraint FK68508F197E512317;
alter table calendar drop constraint FKF55EFB3E75CB2D09;
alter table certificate drop constraint FK745F4197C4027D76;
alter table comment drop constraint FK38A5EE5F889319BC;
alter table commit_item drop constraint FK5A19351B2AEC5E14;
alter table commit_item drop constraint FK5A19351B99AB4086;
alter table contact drop constraint FK38B7242012BCE54F;
alter table contact_extended_property drop constraint FK8C45B7BCFCBFFB3E;
alter table credential drop constraint FKD743E857666EC650;
alter table email_item drop constraint FK4E94C9D642E056DC;
alter table email_item drop constraint FK4E94C9D6A058AC6F;
alter table email_item drop constraint FK4E94C9D67DB36992;
alter table email_item drop constraint FK4E94C9D6AACF6B30;
alter table email_send_attempt drop constraint FK7EF81CD9C331BB44;
alter table email_trigger drop constraint FKD75DEC15AACDDC8E;
alter table enrolement drop constraint FK688BE7D1D457434;
alter table enrolement drop constraint FK688BE7D73B79E62;
alter table fanout_entry drop constraint FKD6C6228E4FF762A6;
alter table forum drop constraint FK5D18D211D457434;
alter table forum_post drop constraint FKCDDDD0FE889319BC;
alter table forum_post drop constraint FKCDDDD0FE8F132661;
alter table forum_reply drop constraint FKEDF3E64C889319BC;
alter table forum_reply drop constraint FKEDF3E64C70AD9EA0;
alter table group_email_job drop constraint FKF4C306DAAACDDC8E;
alter table group_entity drop constraint FKDC016DA3C4027D76;
alter table group_in_website drop constraint FK121949416A085208;
alter table group_in_website drop constraint FK121949411D457434;
alter table group_membership drop constraint FK526319638A2C741;
alter table group_membership drop constraint FK5263196D360BEA0;
alter table group_membership drop constraint FK526319630DCD1AC;
alter table group_membership_application drop constraint FK88BAE42738A2C741;
alter table group_membership_application drop constraint FK88BAE427D360BEA0;
alter table group_membership_application drop constraint FK88BAE42730DCD1AC;
alter table group_membership_application drop constraint FK88BAE4271D457434;
alter table group_membership_application drop constraint FK88BAE4278B021E90;
alter table group_recipient drop constraint FKA73C90592840C316;
alter table group_recipient drop constraint FKA73C9059AACF6B30;
alter table group_reward drop constraint FKF1B2D8EF1FA8C924;
alter table group_reward drop constraint FKF1B2D8EF111E7CB0;
alter table group_role drop constraint FK4C707A3630DCD1AC;
alter table group_role drop constraint FK4C707A36A0FA3AD6;
alter table group_role drop constraint FK4C707A3681447B9;
alter table learner_process drop constraint FKADA71E21CBDEA377;
alter table learner_process drop constraint FKADA71E21666EC650;
alter table learning_log drop constraint FKAA3686A3C4027D76;
alter table learning_log drop constraint FKAA3686A31D457434;
alter table learning_log drop constraint FKAA3686A3666EC650;
alter table membership_process drop constraint FKC4F81706CBDEA377;
alter table module_status drop constraint FKA7AA55251D457434;
alter table module_status drop constraint FKA7AA5525666EC650;
alter table module_status_field drop constraint FK7F08296042C9B4E9;
alter table module_status_process drop constraint FKFE862555CBDEA377;
alter table module_status_process drop constraint FKFE86255542C9B4E9;
alter table nv_pair drop constraint FK89B86AF1E979F767;
alter table org_entity drop constraint FK11F8699E6F774771;
alter table org_entity drop constraint FK11F8699EC4027D76;
alter table password_reset drop constraint FKF4CE9AAB1D457434;
alter table password_reset drop constraint FKF4CE9AAB666EC650;
alter table post drop constraint FK3498A01D457434;
alter table post drop constraint FK3498A03E5139F4;
alter table profile drop constraint FKED8E89A96F774771;
alter table quiz_answer drop constraint FKFD1EC0E8E07A0695;
alter table quiz_attempt drop constraint FKB0FC76E342C9B4E9;
alter table repository drop constraint FK7446DB4AE979F767;
alter table reward drop constraint FKC84F4F2FC4027D76;
alter table reward_entry drop constraint FK7B7C5B621FA8C924;
alter table reward_entry drop constraint FK7B7C5B628FBEE285;
alter table reward_entry drop constraint FK7B7C5B626015418A;
alter table signup_log drop constraint FKE193F79DD360BEA0;
alter table signup_log drop constraint FKE193F79DC4027D76;
alter table signup_log drop constraint FKE193F79D1D457434;
alter table signup_log drop constraint FKE193F79D666EC650;
alter table signup_log drop constraint FKE193F79D5DA60797;
alter table sub_org drop constraint FK90A57C65548BC540;
alter table sub_org drop constraint FK90A57C6590036F4F;
alter table subordinate drop constraint FK9448134C30DCD1AC;
alter table subordinate drop constraint FK9448134C56958E49;
alter table website drop constraint FK48F9E09B2CB36CA7;
alter table website drop constraint FK48F9E09BC4027D76;
alter table website drop constraint FK48F9E09B3A780E63;
drop table access_log if exists;
drop table address_book if exists;
drop table alt_format if exists;
drop table app_control if exists;
drop table app_setting if exists;
drop table base_email_job if exists;
drop table base_entity if exists;
drop table base_process if exists;
drop table blob_hash if exists;
drop table branch if exists;
drop table cal_event if exists;
drop table cal_event_process if exists;
drop table calendar if exists;
drop table certificate if exists;
drop table comment if exists;
drop table commit_item if exists;
drop table contact if exists;
drop table contact_extended_property if exists;
drop table credential if exists;
drop table email_item if exists;
drop table email_send_attempt if exists;
drop table email_trigger if exists;
drop table enrolement if exists;
drop table fanout_entry if exists;
drop table fanout_hash if exists;
drop table forum if exists;
drop table forum_post if exists;
drop table forum_reply if exists;
drop table group_email_job if exists;
drop table group_entity if exists;
drop table group_in_website if exists;
drop table group_membership if exists;
drop table group_membership_application if exists;
drop table group_recipient if exists;
drop table group_reward if exists;
drop table group_role if exists;
drop table learner_process if exists;
drop table learning_log if exists;
drop table media_meta_data if exists;
drop table membership_process if exists;
drop table module_status if exists;
drop table module_status_field if exists;
drop table module_status_process if exists;
drop table named_counter if exists;
drop table nv_pair if exists;
drop table org_entity if exists;
drop table password_reset if exists;
drop table post if exists;
drop table profile if exists;
drop table quiz_answer if exists;
drop table quiz_attempt if exists;
drop table repository if exists;
drop table reward if exists;
drop table reward_entry if exists;
drop table signup_log if exists;
drop table sub_org if exists;
drop table subordinate if exists;
drop table version if exists;
drop table website if exists;
create table access_log (id bigint generated by default as identity (start with 1), content_type varchar(255), duration_ms bigint, num_bytes bigint, referrer varchar(1024), req_date timestamp not null, req_day integer not null, req_from varchar(255), req_host varchar(255), req_hour integer not null, req_method varchar(255) not null, req_month integer not null, req_user varchar(255), req_year integer not null, result_code integer not null, url varchar(255), organisation bigint, website bigint, primary key (id));
create table address_book (id bigint not null, primary key (id));
create table alt_format (id bigint generated by default as identity (start with 1), alt_hash varchar(255) not null, name varchar(255) not null, source_hash varchar(255) not null, primary key (id), unique (name, source_hash));
create table app_control (id bigint generated by default as identity (start with 1), enabled bit not null, modified_date timestamp not null, name varchar(255) not null, modified_by bigint not null, organisation bigint, website_branch bigint, primary key (id), unique (name, organisation, website_branch));
create table app_setting (id bigint generated by default as identity (start with 1), name varchar(255) not null, prop_value varchar(255), app_control bigint, primary key (id), unique (app_control, name));
create table base_email_job (id bigint generated by default as identity (start with 1), from_address varchar(255), html varchar(255), name varchar(255) not null, notes varchar(255), subject varchar(255), title varchar(255), type varchar(255), organisation bigint not null, primary key (id));
create table base_entity (id bigint generated by default as identity (start with 1), created_date timestamp not null, modified_date timestamp not null, name varchar(255) not null, notes varchar(255), type varchar(255), primary key (id), unique (name));
create table base_process (id bigint generated by default as identity (start with 1), process_name varchar(255), process_version integer not null, state_name varchar(255), time_entered timestamp, type varchar(255), primary key (id));
create table blob_hash (blob_hash bigint not null, volume_id bigint not null, primary key (blob_hash));
create table branch (id bigint generated by default as identity (start with 1), created_date timestamp, internal_theme varchar(255), name varchar(255), public_theme varchar(255), lockversion bigint, from_commit bigint, head bigint not null, repository bigint not null, primary key (id), unique (repository, name));
create table cal_event (id bigint generated by default as identity (start with 1), created_date timestamp not null, ctag bigint not null, description varchar(255), end_date timestamp not null, modified_date timestamp not null, name varchar(255) not null, start_date timestamp not null, summary varchar(255), timezone varchar(255), calendar bigint not null, primary key (id));
create table cal_event_process (id bigint not null, cal_event bigint not null, primary key (id));
create table calendar (id bigint generated by default as identity (start with 1), color varchar(255), created_date timestamp not null, ctag bigint not null, modified_date timestamp not null, name varchar(255) not null, owner bigint not null, primary key (id), unique (name, owner));
create table certificate (id bigint generated by default as identity (start with 1), background_image_hash varchar(255), name varchar(255) not null, text varchar(255), title varchar(255) not null, organisation bigint not null, primary key (id), unique (name, organisation));
create table comment (content_href varchar(255) not null, content_id varchar(255) not null, content_title varchar(255) not null, id bigint not null, primary key (id));
create table commit_item (id bigint generated by default as identity (start with 1), created_date timestamp, item_hash varchar(255), previous_commit_id bigint, branch bigint, editor bigint not null, primary key (id));
create table contact (id bigint generated by default as identity (start with 1), given_name varchar(255), mail varchar(255), name varchar(255) not null, organization_name varchar(255), sur_name varchar(255), telephonenumber varchar(255), uid varchar(255) not null, address_book bigint not null, primary key (id));
create table contact_extended_property (id bigint generated by default as identity (start with 1), name varchar(255) not null, prop_value varchar(255) not null, contact bigint not null, primary key (id));
create table credential (type varchar(20) not null, id bigint generated by default as identity (start with 1), created_date timestamp not null, modified_date timestamp not null, password varchar(255) not null, profile bigint not null, primary key (id));
create table email_item (id bigint generated by default as identity (start with 1), bcc_list varchar(255), cc_list varchar(255), content_language varchar(255), created_date timestamp not null, disposition varchar(255), encoding varchar(255), from_address varchar(255) not null, html varchar(20000), message_size integer not null, next_attempt timestamp, num_attempts integer, read_status bit not null, recipient_address varchar(255) not null, reply_to_address varchar(255) not null, send_status varchar(255), send_status_date timestamp not null, subject varchar(255) not null, text varchar(20000), to_list varchar(255), email_trigger bigint, job bigint, recipient bigint, sender bigint, primary key (id));
create table email_send_attempt (id bigint generated by default as identity (start with 1), status varchar(255), status_date timestamp not null, email_item bigint not null, primary key (id));
create table email_trigger (enabled bit not null, event_id varchar(255) not null, include_user bit not null, trigger_condition1 varchar(255), trigger_condition2 varchar(255), trigger_condition3 varchar(255), trigger_condition4 varchar(255), trigger_condition5 varchar(255), id bigint not null, primary key (id));
create table enrolement (id bigint generated by default as identity (start with 1), completable bit, created_date date not null, enroled_course varchar(255), enroled_program varchar(255) not null, modified_date date not null, enroled_group bigint not null, website bigint not null, primary key (id));
create table fanout_entry (id bigint generated by default as identity (start with 1), chunk_hash varchar(255), fanout bigint, primary key (id));
create table fanout_hash (id bigint generated by default as identity (start with 1), actual_content_length bigint not null, fanout_hash varchar(255) not null, type varchar(255) not null, primary key (id), unique (type, fanout_hash));
create table forum (id bigint generated by default as identity (start with 1), name varchar(255) not null, notes varchar(255), title varchar(255) not null, website bigint not null, primary key (id));
create table forum_post (name varchar(255) not null, title varchar(255) not null, id bigint not null, forum bigint not null, primary key (id));
create table forum_reply (id bigint not null, post bigint not null, primary key (id));
create table group_email_job (status varchar(255), status_date timestamp not null, id bigint not null, primary key (id));
create table group_entity (id bigint generated by default as identity (start with 1), created_date timestamp not null, modified_date timestamp not null, name varchar(255) not null, registration_mode varchar(255) not null, organisation bigint not null, primary key (id));
create table group_in_website (id bigint generated by default as identity (start with 1), user_group bigint not null, website bigint not null, primary key (id), unique (user_group, website));
create table group_membership (id bigint generated by default as identity (start with 1), created_date timestamp not null, modified_date timestamp not null, group_entity bigint not null, member bigint not null, within_org bigint not null, primary key (id), unique (member, group_entity, within_org));
create table group_membership_application (id bigint generated by default as identity (start with 1), created_date timestamp not null, modified_date timestamp not null, admin_org bigint not null, group_entity bigint not null, member bigint not null, website bigint, within_org bigint not null, primary key (id));
create table group_recipient (id bigint generated by default as identity (start with 1), job bigint not null, recipient bigint not null, primary key (id));
create table group_reward (id bigint generated by default as identity (start with 1), created_date date, group_to_reward bigint not null, reward bigint not null, primary key (id), unique (group_to_reward, reward));
create table group_role (id bigint generated by default as identity (start with 1), role_name varchar(255) not null, grantee bigint not null, repository bigint, within_org bigint, primary key (id), unique (role_name, grantee, within_org, repository));
create table learner_process (program_code varchar(255), id bigint not null, profile bigint not null, primary key (id));
create table learning_log (id bigint generated by default as identity (start with 1), action varchar(255) not null, course_code varchar(255) not null, program_code varchar(255) not null, req_date timestamp not null, req_day integer not null, req_hour integer not null, req_month integer not null, req_year integer not null, organisation bigint not null, profile bigint not null, website bigint, primary key (id));
create table media_meta_data (id bigint generated by default as identity (start with 1), duration_secs integer, height integer, recorded_date timestamp, source_hash varchar(255) not null, width integer, primary key (id), unique (source_hash));
create table membership_process (membership varbinary(255), id bigint not null, primary key (id));
create table module_status (id bigint generated by default as identity (start with 1), complete bit, course_code varchar(255) not null, created_date date not null, current_page varchar(255), modified_date date not null, module_code varchar(255) not null, percent_complete integer, program_code varchar(255) not null, profile bigint not null, website bigint not null, primary key (id), unique (website, program_code, course_code, module_code, profile));
create table module_status_field (id bigint generated by default as identity (start with 1), mod_date date, name varchar(255) not null, prop_value varchar(255) not null, module_status bigint, primary key (id));
create table module_status_process (id bigint not null, module_status bigint not null, primary key (id));
create table named_counter (id bigint generated by default as identity (start with 1), counter bigint not null, name varchar(255), primary key (id));
create table nv_pair (id bigint generated by default as identity (start with 1), name varchar(255) not null, prop_value varchar(255) not null, base_entity bigint, primary key (id));
create table org_entity (deleted bit, org_id varchar(255) not null, title varchar(255), id bigint not null, organisation bigint, primary key (id), unique (org_id));
create table password_reset (id bigint generated by default as identity (start with 1), created_date timestamp not null, return_url varchar(255) not null, token varchar(255), profile bigint not null, website bigint, primary key (id), unique (token));
create table post (id bigint generated by default as identity (start with 1), notes varchar(2048), post_date timestamp not null, poster bigint not null, website bigint not null, primary key (id));
create table profile (email varchar(255), enabled bit not null, first_name varchar(255), nick_name varchar(255), phone varchar(255), photo_hash varchar(255), rejected bit not null, sur_name varchar(255), id bigint not null, primary key (id));
create table quiz_answer (id bigint generated by default as identity (start with 1), actual_answer varchar(255), answer_key varchar(255) not null, given_answer varchar(255) not null, quiz_attempt bigint, primary key (id));
create table quiz_attempt (id bigint generated by default as identity (start with 1), created_date date not null, passed bit, module_status bigint not null, primary key (id));
create table repository (id bigint generated by default as identity (start with 1), created_date timestamp not null, deleted bit, live_branch varchar(255), name varchar(255) not null, notes varchar(255), public_content bit not null, title varchar(255), type varchar(255), base_entity bigint not null, primary key (id), unique (name, base_entity));
create table reward (id bigint generated by default as identity (start with 1), background_image_hash varchar(255), body varchar(255), email_confirm bit, end_date date, fulfiled_date date, name varchar(255) not null, notes varchar(255), num_awarded integer, quiz_enabled bit not null, quiz_html varchar(255), start_date date, static_message varchar(255), static_message_enabled bit not null, status varchar(255), title varchar(255) not null, user_text_enabled bit not null, user_text_message varchar(255), user_upload_enabled bit not null, user_upload_message varchar(255), organisation bigint not null, primary key (id), unique (name, organisation));
create table reward_entry (id bigint generated by default as identity (start with 1), awarded_date date not null, reason varchar(255) not null, awarded_for bigint, awarded_to bigint not null, reward bigint not null, primary key (id));
create table signup_log (id bigint generated by default as identity (start with 1), req_date timestamp not null, req_day integer not null, req_hour integer not null, req_month integer not null, req_year integer not null, group_entity bigint, membership_org bigint, organisation bigint, profile bigint, website bigint, primary key (id));
create table sub_org (id bigint generated by default as identity (start with 1), owner bigint not null, suborg bigint not null, primary key (id));
create table subordinate (id bigint generated by default as identity (start with 1), group_membership bigint not null, within_org bigint not null, primary key (id));
create table version (id bigint generated by default as identity (start with 1), mod_date timestamp not null, mod_hash varchar(255) not null, previous_mod_hash varchar(255) not null, profile_id bigint not null, resource_hash varchar(255) not null, primary key (id));
create table website (domain_name varchar(255), mail_server varchar(255), redirect_to varchar(255), id bigint not null, alias_to bigint, organisation bigint not null, primary key (id), unique (domain_name));
alter table access_log add constraint FKBBF335E9C4027D76 foreign key (organisation) references org_entity;
alter table access_log add constraint FKBBF335E91D457434 foreign key (website) references website;
alter table address_book add constraint FKFB8B0542CB36CA7 foreign key (id) references repository;
alter table app_control add constraint FKEE00D53FC4027D76 foreign key (organisation) references org_entity;
alter table app_control add constraint FKEE00D53F1CD5CA34 foreign key (modified_by) references profile;
alter table app_control add constraint FKEE00D53F849B88AA foreign key (website_branch) references branch;
alter table app_setting add constraint FK2BA87E323BD6907C foreign key (app_control) references app_control;
alter table base_email_job add constraint FK2F3D58ACC4027D76 foreign key (organisation) references org_entity;
create index ids_entity_name on base_entity (name);
create index ids_blobhash on blob_hash (blob_hash);
alter table branch add constraint FKADAF25A2EDBCEC59 foreign key (head) references commit_item;
alter table branch add constraint FKADAF25A2A0FA3AD6 foreign key (repository) references repository;
alter table branch add constraint FKADAF25A2DE9B19E5 foreign key (from_commit) references commit_item;
alter table cal_event add constraint FKABCCC2E9C9A2A33E foreign key (calendar) references calendar;
alter table cal_event_process add constraint FK68508F19CBDEA377 foreign key (id) references base_process;
alter table cal_event_process add constraint FK68508F197E512317 foreign key (cal_event) references cal_event;
alter table calendar add constraint FKF55EFB3E75CB2D09 foreign key (owner) references base_entity;
alter table certificate add constraint FK745F4197C4027D76 foreign key (organisation) references org_entity;
alter table comment add constraint FK38A5EE5F889319BC foreign key (id) references post;
alter table commit_item add constraint FK5A19351B2AEC5E14 foreign key (editor) references profile;
alter table commit_item add constraint FK5A19351B99AB4086 foreign key (branch) references branch;
alter table contact add constraint FK38B7242012BCE54F foreign key (address_book) references address_book;
alter table contact_extended_property add constraint FK8C45B7BCFCBFFB3E foreign key (contact) references contact;
alter table credential add constraint FKD743E857666EC650 foreign key (profile) references profile;
alter table email_item add constraint FK4E94C9D642E056DC foreign key (sender) references profile;
alter table email_item add constraint FK4E94C9D6A058AC6F foreign key (recipient) references base_entity;
alter table email_item add constraint FK4E94C9D67DB36992 foreign key (email_trigger) references email_trigger;
alter table email_item add constraint FK4E94C9D6AACF6B30 foreign key (job) references base_email_job;
alter table email_send_attempt add constraint FK7EF81CD9C331BB44 foreign key (email_item) references email_item;
alter table email_trigger add constraint FKD75DEC15AACDDC8E foreign key (id) references base_email_job;
alter table enrolement add constraint FK688BE7D1D457434 foreign key (website) references website;
alter table enrolement add constraint FK688BE7D73B79E62 foreign key (enroled_group) references group_entity;
create index ids_chunk_hash on fanout_entry (chunk_hash);
alter table fanout_entry add constraint FKD6C6228E4FF762A6 foreign key (fanout) references fanout_hash;
alter table forum add constraint FK5D18D211D457434 foreign key (website) references website;
alter table forum_post add constraint FKCDDDD0FE889319BC foreign key (id) references post;
alter table forum_post add constraint FKCDDDD0FE8F132661 foreign key (forum) references forum;
alter table forum_reply add constraint FKEDF3E64C889319BC foreign key (id) references post;
alter table forum_reply add constraint FKEDF3E64C70AD9EA0 foreign key (post) references forum_post;
alter table group_email_job add constraint FKF4C306DAAACDDC8E foreign key (id) references base_email_job;
alter table group_entity add constraint FKDC016DA3C4027D76 foreign key (organisation) references org_entity;
alter table group_in_website add constraint FK121949416A085208 foreign key (user_group) references group_entity;
alter table group_in_website add constraint FK121949411D457434 foreign key (website) references website;
alter table group_membership add constraint FK526319638A2C741 foreign key (member) references profile;
alter table group_membership add constraint FK5263196D360BEA0 foreign key (group_entity) references group_entity;
alter table group_membership add constraint FK526319630DCD1AC foreign key (within_org) references org_entity;
alter table group_membership_application add constraint FK88BAE42738A2C741 foreign key (member) references profile;
alter table group_membership_application add constraint FK88BAE427D360BEA0 foreign key (group_entity) references group_entity;
alter table group_membership_application add constraint FK88BAE42730DCD1AC foreign key (within_org) references org_entity;
alter table group_membership_application add constraint FK88BAE4271D457434 foreign key (website) references website;
alter table group_membership_application add constraint FK88BAE4278B021E90 foreign key (admin_org) references org_entity;
alter table group_recipient add constraint FKA73C90592840C316 foreign key (recipient) references group_entity;
alter table group_recipient add constraint FKA73C9059AACF6B30 foreign key (job) references base_email_job;
alter table group_reward add constraint FKF1B2D8EF1FA8C924 foreign key (reward) references reward;
alter table group_reward add constraint FKF1B2D8EF111E7CB0 foreign key (group_to_reward) references group_entity;
alter table group_role add constraint FK4C707A3630DCD1AC foreign key (within_org) references org_entity;
alter table group_role add constraint FK4C707A36A0FA3AD6 foreign key (repository) references repository;
alter table group_role add constraint FK4C707A3681447B9 foreign key (grantee) references group_entity;
alter table learner_process add constraint FKADA71E21CBDEA377 foreign key (id) references base_process;
alter table learner_process add constraint FKADA71E21666EC650 foreign key (profile) references profile;
alter table learning_log add constraint FKAA3686A3C4027D76 foreign key (organisation) references org_entity;
alter table learning_log add constraint FKAA3686A31D457434 foreign key (website) references website;
alter table learning_log add constraint FKAA3686A3666EC650 foreign key (profile) references profile;
alter table membership_process add constraint FKC4F81706CBDEA377 foreign key (id) references base_process;
alter table module_status add constraint FKA7AA55251D457434 foreign key (website) references website;
alter table module_status add constraint FKA7AA5525666EC650 foreign key (profile) references profile;
alter table module_status_field add constraint FK7F08296042C9B4E9 foreign key (module_status) references module_status;
alter table module_status_process add constraint FKFE862555CBDEA377 foreign key (id) references base_process;
alter table module_status_process add constraint FKFE86255542C9B4E9 foreign key (module_status) references module_status;
alter table nv_pair add constraint FK89B86AF1E979F767 foreign key (base_entity) references base_entity;
create index idx_orgId on org_entity (org_id);
alter table org_entity add constraint FK11F8699E6F774771 foreign key (id) references base_entity;
alter table org_entity add constraint FK11F8699EC4027D76 foreign key (organisation) references org_entity;
alter table password_reset add constraint FKF4CE9AAB1D457434 foreign key (website) references website;
alter table password_reset add constraint FKF4CE9AAB666EC650 foreign key (profile) references profile;
alter table post add constraint FK3498A01D457434 foreign key (website) references website;
alter table post add constraint FK3498A03E5139F4 foreign key (poster) references profile;
create index ids_profile_email on profile (email);
alter table profile add constraint FKED8E89A96F774771 foreign key (id) references base_entity;
alter table quiz_answer add constraint FKFD1EC0E8E07A0695 foreign key (quiz_attempt) references quiz_attempt;
alter table quiz_attempt add constraint FKB0FC76E342C9B4E9 foreign key (module_status) references module_status;
alter table repository add constraint FK7446DB4AE979F767 foreign key (base_entity) references base_entity;
alter table reward add constraint FKC84F4F2FC4027D76 foreign key (organisation) references org_entity;
alter table reward_entry add constraint FK7B7C5B621FA8C924 foreign key (reward) references reward;
alter table reward_entry add constraint FK7B7C5B628FBEE285 foreign key (awarded_to) references profile;
alter table reward_entry add constraint FK7B7C5B626015418A foreign key (awarded_for) references module_status;
alter table signup_log add constraint FKE193F79DD360BEA0 foreign key (group_entity) references group_entity;
alter table signup_log add constraint FKE193F79DC4027D76 foreign key (organisation) references org_entity;
alter table signup_log add constraint FKE193F79D1D457434 foreign key (website) references website;
alter table signup_log add constraint FKE193F79D666EC650 foreign key (profile) references profile;
alter table signup_log add constraint FKE193F79D5DA60797 foreign key (membership_org) references org_entity;
alter table sub_org add constraint FK90A57C65548BC540 foreign key (suborg) references org_entity;
alter table sub_org add constraint FK90A57C6590036F4F foreign key (owner) references org_entity;
alter table subordinate add constraint FK9448134C30DCD1AC foreign key (within_org) references org_entity;
alter table subordinate add constraint FK9448134C56958E49 foreign key (group_membership) references group_membership;
create index idx_version_modhash on version (mod_hash);
create index idx_domain_name on website (domain_name);
alter table website add constraint FK48F9E09B2CB36CA7 foreign key (id) references repository;
alter table website add constraint FK48F9E09BC4027D76 foreign key (organisation) references org_entity;
alter table website add constraint FK48F9E09B3A780E63 foreign key (alias_to) references website;
