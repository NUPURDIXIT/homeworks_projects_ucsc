drop table if exists visitors;
CREATE TABLE `visitors` (
  `id` integer primary key autoincrement,
  `visitor_name` text,
  `email` text ,
  `phone_number` text,
  `employee_name` text,
  `visit_date` timestamp
 );
