	CREATE TABLE IF NOT EXISTS `${Connection}` 
	(`room_id1` INTEGER NOT NULL, 
	`room_id2` INTEGER NOT NULL, 
	PRIMARY KEY(`room_id1`, `room_id2`), 
	FOREIGN KEY(`room_id1`) 
	REFERENCES `RoomEntity`(`room_id`) 
	ON UPDATE NO ACTION ON DELETE NO ACTION , 
	OREIGN KEY(`room_id2`) REFERENCES `RoomEntity`(`room_id`) 
	ON UPDATE NO ACTION ON DELETE NO ACTION );
	
	CREATE  INDEX `index_Connection_room_id1` ON `${Connection}` 
	(`room_id1`);
	
	CREATE  INDEX `index_Connection_room_id2` ON `${Connection}` 
	(`room_id2`);
	
	
	
	CREATE TABLE IF NOT EXISTS `${History}` 
	(`problem_id` TEXT NOT NULL, 
	`user_id` TEXT NOT NULL, 
	PRIMARY KEY(`problem_id`), 
	FOREIGN KEY(`user_id`) 
	REFERENCES `UserInformation`(`user_id`) 
	ON UPDATE NO ACTION ON DELETE NO ACTION );
	
	CREATE  INDEX `index_History_problem_id` ON `${History}` 
	(`problem_id`);
	
	CREATE  INDEX `index_History_user_id` ON `${History}`
	(`user_id`);
	
	
	CREATE TABLE IF NOT EXISTS `${Level}` 
	(`level_id` INTEGER NOT NULL, 
	`level_title` TEXT NOT NULL, 
	`level_of_difficulty_of_problems` INTEGER NOT NULL, 
	`scenario_id` INTEGER NOT NULL, 
	PRIMARY KEY(`level_id`));
	
	CREATE  INDEX `index_Level_level_id` ON `${Level}` 
	(`level_id`);
	
	CREATE  INDEX `index_Level_level_title` ON `${Level}` 
	(`level_title`);
	
	
	
	CREATE TABLE IF NOT EXISTS `${MathProblem}` 
	(`problem_id` INTEGER NOT NULL, 
	`difficulty` INTEGER NOT NULL, 
	`type` INTEGER NOT NULL, `correct_answer` TEXT, 
	`incorrect_answer` TEXT, `attempts` INTEGER NOT NULL, 
	`pool_of_problems` TEXT NOT NULL, 
	`outcome` INTEGER NOT NULL, 
	PRIMARY KEY(`problem_id`));
	
	
	CREATE  INDEX `index_MathProblem_problem_id` ON `${MathProblem}`
	(`problem_id`);
	
	
	CREATE  INDEX `index_MathProblem_difficulty` ON `${MathProblem}` 
	(`difficulty`);
	
	CREATE  INDEX `index_MathProblem_type` ON `${MathProblem}` 
	(`type`);
	
	CREATE  INDEX `index_MathProblem_correct_answer` ON `${MathProblem}` 
	(`correct_answer`);
	
	
	CREATE  INDEX `index_MathProblem_incorrect_answer` ON `${MathProblem}` 
	(`incorrect_answer`);
	
	CREATE  INDEX `index_MathProblem_attempts` ON `${MathProblem}` 
	(`attempts`);
	
	
	CREATE  INDEX `index_MathProblem_outcome` ON `${MathProblem}` 
	(`outcome`);
	
	
	CREATE TABLE IF NOT EXISTS `${RoomEntity}` 
	(`room_id` INTEGER NOT NULL, 
	`level_id` INTEGER NOT NULL, 
	PRIMARY KEY(`room_id`), 
	FOREIGN KEY(`level_id`) REFERENCES `Level`(`level_id`) 
	ON UPDATE NO ACTION ON DELETE NO ACTION );
	
	CREATE  INDEX `index_RoomEntity_room_id` ON `${RoomEntity}`
	(`room_id`);
	
	CREATE  INDEX `index_RoomEntity_level_id` ON `${RoomEntity}` 
	(`level_id`);
	
	CREATE TABLE IF NOT EXISTS `${Scenario}` 
	(`scenario_id` INTEGER NOT NULL, 
	`scenario_title` TEXT NOT NULL, 
	PRIMARY KEY(`scenario_id`));
	
	CREATE UNIQUE INDEX `index_Scenario_scenario_title` ON `${Scenario}` 
	(`scenario_title`);
	
	CREATE  INDEX `index_Scenario_scenario_id` ON `${Scenario}`
	(`scenario_id`);
	
	CREATE TABLE IF NOT EXISTS `${UserInformation}` 
	(`user_id` TEXT NOT NULL, 
	`username` TEXT NOT NULL, 
	`user_progress` TEXT NOT NULL, 
	PRIMARY KEY(`user_id`));
	
	CREATE  INDEX `index_UserInformation_user_id` ON `${UserInformation}` 
	(`user_id`);
	
	CREATE  INDEX `index_UserInformation_username` ON `${UserInformation}` 
	(`username`);
	
	CREATE  INDEX `index_UserInformation_user_progress` ON `${UserInformation}` 
	(`user_progress`);
	
	CREATE TABLE IF NOT EXISTS room_master_table 
	(id INTEGER PRIMARY KEY,identity_hash TEXT);
	
	
	
	
	
	
	