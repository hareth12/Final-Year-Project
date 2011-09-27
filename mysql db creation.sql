CREATE  TABLE `fyp`.`accountLinkClass` (

  `indexHash` VARCHAR(40) NOT NULL ,

  `payeeAccount` BIGINT(20) NOT NULL ,

  `payerAccount` BIGINT(20) NOT NULL ,

  `idPib` VARCHAR(45) NOT NULL ,

  `hash2FA` VARCHAR(45) NULL ,

  `pre2FAHash` VARCHAR(45) NULL ,

  `timeStarted` BIGINT(20) NULL ,

  `timeToEnd` BIGINT(20) NULL ,

  `amountPending` FLOAT NULL ,

  `validLink` TINYINT(1) NULL ,

  `telephone` VARCHAR(20) NOT NULL ,

  `fromType` VARCHAR(45) NOT NULL ,

  `toType` VARCHAR(45) NOT NULL ,

  PRIMARY KEY (`indexHash`) );
  


  
  CREATE  TABLE `fyp`.`trustClass` (

  `cookieHash` VARCHAR(45) NOT NULL ,

  `loginName` VARCHAR(45) NOT NULL ,

  `timestarted` BIGINT(20) NOT NULL ,

  `timetoend` BIGINT(20) NOT NULL ,

  `is2FA` TINYINT NOT NULL ,

  PRIMARY KEY (`cookieHash`) );
  
  
  

  
  
  CREATE  TABLE `fyp`.`loginclass` (

  `idCustomer` INT(11) NOT NULL ,

  `idPib` VARCHAR(20) NOT NULL ,

  `password` VARCHAR(20) NOT NULL ,

  `telephone` VARCHAR(20) NOT NULL ,

  `hash2FA` VARCHAR(45) NOT NULL ,

  `pre2FAHash` VARCHAR(45) NOT NULL ,

  `timestarted` BIGINT(20) NOT NULL ,

  `timetoEnd` BIGINT(20) NOT NULL ,

  PRIMARY KEY (`idPib`) );
  
  CREATE  TABLE `fyp`.`accountclass` (

  `accountnumber` BIGINT(20) NOT NULL ,

  `currentBalance` FLOAT NOT NULL ,

  `availableBalance` FLOAT NOT NULL ,

  `accountType` VARCHAR(45) NOT NULL ,

  `idPib` VARCHAR(45) NOT NULL ,

  PRIMARY KEY (`accountnumber`) ) ;
  
  
  INSERT INTO `fyp`.`loginclass` (`idCustomer`, `idPib`, `password`, `telephone`, `hash2FA`, `pre2FAHash`, `timestarted`, `timetoEnd`) VALUES (1, 'zhongqin', '12345', '90497848', '123456', 'noik', 2131290, 1283423542085);
  
  INSERT INTO `fyp`.`accountclass` (`accountnumber`, `currentBalance`, `availableBalance`, `accountType`, `idPib`) VALUES (11111111111, 111.11, 111.11, 'Uniplus', 'Uniplus');
  
  
  INSERT INTO `fyp`.`accountclass` (`accountnumber`, `currentBalance`, `availableBalance`, `accountType`, `idPib`) VALUES (11111111112, 124.3, 124.3, 'Uniplus', 'zhongqin');

UPDATE `fyp`.`accountclass` SET `idPib`='zhongqin' WHERE `accountnumber`='11111111111';


INSERT INTO `fyp`.`trustClass` (`cookieHash`, `loginName`, `timestarted`, `timetoend`, `is2FA`) VALUES ('1234567890123456789012345678901234567890', 'zhongqin', 123, 12315555353, 1);

INSERT INTO `fyp`.`trustClass` (`cookieHash`, `loginName`, `timestarted`, `timetoend`, `is2FA`) VALUES ('abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcde', 'zhongcai', 123, 134325357678, 1);


INSERT INTO `fyp`.`accountLinkClass` (`indexHash`, `payeeAccount`, `payerAccount`, `idPib`, `hash2FA`, `pre2FAHash`, `timeStarted`, `timeToEnd`, `amountPending`, `validLink`, `telephone`, `fromType`, `toType`) VALUES ('32sfjoxcjovmnlnhsoahoik', 11111111112, 11111111111, 'zhongqin', '123456', 'hsnk', 1231212, 123543543, 0, 1, '90497848', 'Uniplus', 'Uniplus');