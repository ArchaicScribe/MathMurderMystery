[DDL][docs/ddl.md]

```sql


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
	
	
	CREATE TABLE IF NOT EXISTS `${History}` 
	(`problem_id` TEXT NOT NULL, 
	`user_id` TEXT NOT NULL, 
	PRIMARY KEY(`problem_id`), 
	FOREIGN KEY(`user_id`) 
	REFERENCES `UserInformation`(`user_id`) 
	ON UPDATE NO ACTION ON DELETE NO ACTION );
	
	CREATE TABLE IF NOT EXISTS `${Level}` 
	(`level_id` INTEGER NOT NULL, 
	`level_title` TEXT NOT NULL, 
	`level_of_difficulty_of_problems` INTEGER NOT NULL, 
	`scenario_id` INTEGER NOT NULL, 
	PRIMARY KEY(`level_id`));
	
	CREATE TABLE IF NOT EXISTS `${MathProblem}` 
	(`problem_id` INTEGER NOT NULL, 
	`difficulty` INTEGER NOT NULL, 
	`type` INTEGER NOT NULL, `correct_answer` TEXT, 
	`incorrect_answer` TEXT, `attempts` INTEGER NOT NULL, 
	`pool_of_problems` TEXT NOT NULL, 
	`outcome` INTEGER NOT NULL, 
	PRIMARY KEY(`problem_id`));
	
	
	CREATE TABLE IF NOT EXISTS `${RoomEntity}` 
	(`room_id` INTEGER NOT NULL, 
	`level_id` INTEGER NOT NULL, 
	PRIMARY KEY(`room_id`), 
	FOREIGN KEY(`level_id`) REFERENCES `Level`(`level_id`) 
	ON UPDATE NO ACTION ON DELETE NO ACTION )
	
	
	
	
```
	
	
	
	