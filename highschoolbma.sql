/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50716
Source Host           : localhost:3308
Source Database       : highschoolbma

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-05-02 14:38:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `books`
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `ISBN` varchar(255) NOT NULL,
  `edition` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=199 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('5', 'This public', 'domain', '9781469627328', '0');
INSERT INTO `books` VALUES ('7', 'A MAP fixed-point, packing-unpacking routine for the IBM 7094 computer', 'Robert S. Helfman', '97814696234566', '0');
INSERT INTO `books` VALUES ('8', 'Kukun the Kangaroo Gets a New Computer', 'Helfman', '9783540727347', '0');
INSERT INTO `books` VALUES ('9', 'An analysis of computer security safeguards for detecting and preventing intentional computer misuse', 'Brian Ruder', '9783540727347', '1');
INSERT INTO `books` VALUES ('10', 'Logical Foundations of Computer Science', 'Sergei Artemov', '9783540727347', '0');
INSERT INTO `books` VALUES ('11', 'Computer Skills for Little Kids', 'Zo? Hulme', '9783540727347', '0');
INSERT INTO `books` VALUES ('12', 'COMPUTER ORGANIZATION AND DESIGN', 'P. PAL CHAUDHURI', '9783540727347', '0');
INSERT INTO `books` VALUES ('13', 'Component List for Computer, Gun Direction, M18 (FADAC) (1220-00-448-0131).', 'Duncan', '9783540727347', '0');
INSERT INTO `books` VALUES ('14', 'Computer, Informatics, Cybernetics and Applications', 'Xingui He', '9783540727347', '0');
INSERT INTO `books` VALUES ('15', 'Computer Engineering Reference Manual for the Electrical and Computer PE Exam', 'John A. Camara, PE', '9783540727347', '0');
INSERT INTO `books` VALUES ('16', 'Digital Logic Design and Computer Organization with Computer Architecture for Security', 'Nikrouz Faroughi', '9783540727347', '0');
INSERT INTO `books` VALUES ('17', 'A MAP fixed-point, packing-unpacking routine for the IBM 7094 computer', 'Robert S. Helfman', 'MINN:31951D02995574S', '0');
INSERT INTO `books` VALUES ('18', 'Kukun the Kangaroo Gets a New Computer', '9781434976765', '9783540727347', '0');
INSERT INTO `books` VALUES ('19', 'An analysis of computer security safeguards for detecting and preventing intentional computer misuse', 'Brian Ruder', 'UIUC:30112101031091', '0');
INSERT INTO `books` VALUES ('20', 'Logical Foundations of Computer Science', 'Sergei Artemov', '9783540727347', '0');
INSERT INTO `books` VALUES ('21', 'Computer Skills for Little Kids', 'Zo? Hulme', '9781863974158', '0');
INSERT INTO `books` VALUES ('22', 'COMPUTER ORGANIZATION AND DESIGN', 'P. PAL CHAUDHURI', '8120335112', '0');
INSERT INTO `books` VALUES ('23', 'Component List for Computer, Gun Direction, M18 (FADAC) (1220-00-448-0131).', 'UVA:X004816266', '', '0');
INSERT INTO `books` VALUES ('24', 'Computer, Informatics, Cybernetics and Applications', 'Xingui He', '940071839X', '0');
INSERT INTO `books` VALUES ('25', 'Computer Engineering Reference Manual for the Electrical and Computer PE Exam', 'John A. Camara, PE', '9781591261704', '0');
INSERT INTO `books` VALUES ('26', 'Digital Logic Design and Computer Organization with Computer Architecture for Security', 'Nikrouz Faroughi', '9780071838085', '0');
INSERT INTO `books` VALUES ('27', 'A Dictionary of the Chinese Language: English and Chinese', 'Robert Morrison', 'NYPL:33433081856738', '0');
INSERT INTO `books` VALUES ('28', 'Chinese Cut-Paper Animal Designs', 'Dover', '9780486154039', '0');
INSERT INTO `books` VALUES ('29', 'A Dictionary from English to Colloquial Mandarin Chinese', 'George Carter Stent', 'HARVARD:32044060212156', '0');
INSERT INTO `books` VALUES ('30', 'The Bradys\' Chinese Clew', 'STANFORD:36105115591385', '', '0');
INSERT INTO `books` VALUES ('31', 'A History of Chinese Literature', 'Herbert Allen Giles', 'UOM:39015004733138', '0');
INSERT INTO `books` VALUES ('32', 'A Chinese-English Dictionary', 'Herbert Allen Giles', 'UOM:39015086589044', '0');
INSERT INTO `books` VALUES ('33', 'Progressive Exercises in the Chinese Written Language', 'Thomas Lowndes Bullock', 'PRNC:32101067640555', '0');
INSERT INTO `books` VALUES ('34', 'Translation of the Ts\'ing wan k\'e mung, a Chinese Grammar of the Manchu Tartar Language; with introductory notes on Manchu Literature', 'BSB:BSB10251453', '', '0');
INSERT INTO `books` VALUES ('35', 'Sanctity and Self-Inflicted Violence in Chinese Religions, 1500-1700', 'Jimmy Yu', '9780199844890', '0');
INSERT INTO `books` VALUES ('36', 'The Chinese Classics', 'James Legge', 'RMS:RMS1LSO$000005564$$$Q', '0');
INSERT INTO `books` VALUES ('37', 'A Dictionary of the Chinese Language: English and Chinese', 'Robert Morrison', 'NYPL:33433081856738', '0');
INSERT INTO `books` VALUES ('38', 'Chinese Cut-Paper Animal Designs', 'Dover', '9780486154039', '0');
INSERT INTO `books` VALUES ('39', 'A Dictionary from English to Colloquial Mandarin Chinese', 'George Carter Stent', 'HARVARD:32044060212156', '0');
INSERT INTO `books` VALUES ('40', 'The Bradys\' Chinese Clew', 'STANFORD:36105115591385', '', '0');
INSERT INTO `books` VALUES ('41', 'A History of Chinese Literature', 'Herbert Allen Giles', 'UOM:39015004733138', '0');
INSERT INTO `books` VALUES ('42', 'A Chinese-English Dictionary', 'Herbert Allen Giles', 'UOM:39015086589044', '0');
INSERT INTO `books` VALUES ('43', 'Progressive Exercises in the Chinese Written Language', 'Thomas Lowndes Bullock', 'PRNC:32101067640555', '0');
INSERT INTO `books` VALUES ('44', 'Translation of the Ts\'ing wan k\'e mung, a Chinese Grammar of the Manchu Tartar Language; with introductory notes on Manchu Literature', 'BSB:BSB10251453', '', '0');
INSERT INTO `books` VALUES ('45', 'Sanctity and Self-Inflicted Violence in Chinese Religions, 1500-1700', 'Jimmy Yu', '9780199844890', '0');
INSERT INTO `books` VALUES ('46', 'The Chinese Classics', 'James Legge', 'RMS:RMS1LSO$000005564$$$Q', '0');
INSERT INTO `books` VALUES ('47', 'Math Minutes, 7th Grade, eBook', 'Doug Stoffel', '9781591988373', '0');
INSERT INTO `books` VALUES ('48', 'Math Mystery Theater', '0848100700', '', '0');
INSERT INTO `books` VALUES ('49', 'Practical Business Math Procedures', 'Jeffrey Slater', '9780077534042', '0');
INSERT INTO `books` VALUES ('50', 'ACT Math For Dummies', 'Mark Zegarelli', '9781118077405', '0');
INSERT INTO `books` VALUES ('51', 'Guided Math Workshop', 'Laney Sammons', '9781425896775', '0');
INSERT INTO `books` VALUES ('52', 'The Math Handbook', 'Richard Elwes', '9781623652944', '0');
INSERT INTO `books` VALUES ('53', 'Basic Electronics Math', 'Clyde Herrick', '9780080499802', '0');
INSERT INTO `books` VALUES ('54', 'Master the GED: Math Review--Geometry', 'Peterson\'s', '9780768933598', '0');
INSERT INTO `books` VALUES ('55', 'Carmina syncharistica Math. Kager inscripta', 'Johann Engerd', 'BSB:BSB10152314', '0');
INSERT INTO `books` VALUES ('56', 'Baseball Math', 'Christopher Jennison', '9781596473539', '0');
INSERT INTO `books` VALUES ('57', 'Edexcel A-level Chemistry Student Guide: Practical Chemistry', 'David Scott', '9781471885693', '0');
INSERT INTO `books` VALUES ('58', 'Animal Chemistry or Organic Chemistry in its application to Physiology and Pathologie by Justus Liebig', 'Justus von Liebig', 'BSB:BSB10073244', '0');
INSERT INTO `books` VALUES ('59', 'A Select Bibliography of Chemistry, 1492-1897', 'Henry Carrington Bolton', 'WISC:89097563787', '0');
INSERT INTO `books` VALUES ('60', 'A select bibliography of chemistry, 1492-1902', 'Henry Carrington Bolton', 'UIUC:30112106728998', '0');
INSERT INTO `books` VALUES ('61', 'Art in Chemistry, Chemistry in Art', 'Barbara R. Greenberg', '1563084872', '0');
INSERT INTO `books` VALUES ('62', 'Contribution to the Chemistry of the Mineral Springs of Onondaga, New York', 'Charles Anthony Goessmann', 'UCAL:B2841425', '0');
INSERT INTO `books` VALUES ('63', 'A Dictionary of Practical and Theoretical Chemistry', 'William Nicholson', 'UCM:5319412957', '0');
INSERT INTO `books` VALUES ('64', 'The Chemistry of Heterocyclic Compounds, The Chemistry of 1,2,3-Thiadiazoles', 'Wim Dehaen', '9780471656913', '0');
INSERT INTO `books` VALUES ('65', 'SAT Subject Test: Chemistry, 9th Ed.', '0764192760', '', '0');
INSERT INTO `books` VALUES ('66', 'BIOS Instant Notes in Analytical Chemistry', 'David Kealey', '9780203645444', '0');
INSERT INTO `books` VALUES ('67', 'Biology of Embaphion Muricatum', 'Joseph Sanford Wade', 'HARVARD:32044107191058', '0');
INSERT INTO `books` VALUES ('68', 'A New Fresh-water Amphipod from Virginia, with Some Notes on Its Biology', 'George Charles Embody', 'HARVARD:32044107164410', '0');
INSERT INTO `books` VALUES ('69', 'Soil Biology Primer', 'UVA:X005066799', '', '0');
INSERT INTO `books` VALUES ('70', 'Comprehensive Laboratory Manual In Biology XI', 'Dr. J. P. Sharma', '9788131801642', '0');
INSERT INTO `books` VALUES ('71', 'Marine Biology', 'Peter Castro', '9781259162503', '0');
INSERT INTO `books` VALUES ('72', 'Cracking the AP Biology Exam, 2018 Edition', 'Princeton Review', '9781524710354', '0');
INSERT INTO `books` VALUES ('73', 'Henderson\'s Dictionary of Biology', 'Eleanor Lawrence', '9781292086095', '0');
INSERT INTO `books` VALUES ('74', 'Dynamic Models in Biology', 'Stephen P. Ellner', '9781400840960', '0');
INSERT INTO `books` VALUES ('75', 'STM and SFM in Biology', 'Othmar Marti', '9780323138857', '0');
INSERT INTO `books` VALUES ('76', 'Biology, with Preludes on Current Events', 'Joseph Cook', 'NYPL:33433010813958', '0');
INSERT INTO `books` VALUES ('77', 'Biology of Embaphion Muricatum', 'Joseph Sanford Wade', 'HARVARD:32044107191058', '0');
INSERT INTO `books` VALUES ('78', 'A New Fresh-water Amphipod from Virginia, with Some Notes on Its Biology', 'George Charles Embody', 'HARVARD:32044107164410', '0');
INSERT INTO `books` VALUES ('79', 'Soil Biology Primer', 'UVA:X005066799', '', '0');
INSERT INTO `books` VALUES ('80', 'Comprehensive Laboratory Manual In Biology XI', 'Dr. J. P. Sharma', '9788131801642', '0');
INSERT INTO `books` VALUES ('81', 'Marine Biology', 'Peter Castro', '9781259162503', '0');
INSERT INTO `books` VALUES ('82', 'Cracking the AP Biology Exam, 2018 Edition', 'Princeton Review', '9781524710354', '0');
INSERT INTO `books` VALUES ('83', 'Henderson\'s Dictionary of Biology', 'Eleanor Lawrence', '9781292086095', '0');
INSERT INTO `books` VALUES ('84', 'Dynamic Models in Biology', 'Stephen P. Ellner', '9781400840960', '0');
INSERT INTO `books` VALUES ('85', 'STM and SFM in Biology', 'Othmar Marti', '9780323138857', '0');
INSERT INTO `books` VALUES ('86', 'Biology, with Preludes on Current Events', 'Joseph Cook', 'NYPL:33433010813958', '0');
INSERT INTO `books` VALUES ('87', 'Museum-history and Museums of History', 'George Brown Goode', 'HARVARD:32044072249105', '0');
INSERT INTO `books` VALUES ('88', 'Museum-history and Museums of History', 'George Brown Goode', 'HARVARD:32044072249105', '0');
INSERT INTO `books` VALUES ('89', 'Aristotle\'s Politics', 'Aristotle', 'UOM:39015066423750', '0');
INSERT INTO `books` VALUES ('90', 'Women and Politics', 'Charles Kingsley', '9781465526441', '0');
INSERT INTO `books` VALUES ('91', 'The Justice Cascade: How Human Rights Prosecutions Are Changing World Politics (The Norton Series in World Politics)', 'Kathryn Sikkink', '9780393083286', '0');
INSERT INTO `books` VALUES ('92', 'Turmoil in Punjab Politics', 'Subhash Chander Arora', '8170992516', '0');
INSERT INTO `books` VALUES ('93', 'Politics', 'Adam Thirlwell', '0061881880', '0');
INSERT INTO `books` VALUES ('94', 'Iranian History and Politics', 'Homa Katouzian', '9781134430956', '0');
INSERT INTO `books` VALUES ('95', 'The Politics of Age and Disability in Contemporary Spanish Film', 'Matthew J. Marr', '9781136227301', '0');
INSERT INTO `books` VALUES ('96', 'The American Journal of Politics', 'STANFORD:36105007427243', '', '0');
INSERT INTO `books` VALUES ('97', 'Lincoln and the Politics of Slavery', 'Daniel W. Crofts', '9781469627328', '0');
INSERT INTO `books` VALUES ('98', 'The Logic of Japanese Politics', 'Gerald L. Curtis', '9780231502542', '0');
INSERT INTO `books` VALUES ('99', 'Aristotle\'s Politics', 'Aristotle', 'UOM:39015066423750', '0');
INSERT INTO `books` VALUES ('100', 'Women and Politics', 'Charles Kingsley', '9781465526441', '0');
INSERT INTO `books` VALUES ('101', 'The Justice Cascade: How Human Rights Prosecutions Are Changing World Politics (The Norton Series in World Politics)', 'Kathryn Sikkink', '9780393083286', '0');
INSERT INTO `books` VALUES ('102', 'Turmoil in Punjab Politics', 'Subhash Chander Arora', '8170992516', '0');
INSERT INTO `books` VALUES ('103', 'Politics', 'Adam Thirlwell', '0061881880', '0');
INSERT INTO `books` VALUES ('104', 'Iranian History and Politics', 'Homa Katouzian', '9781134430956', '0');
INSERT INTO `books` VALUES ('105', 'The Politics of Age and Disability in Contemporary Spanish Film', 'Matthew J. Marr', '9781136227301', '0');
INSERT INTO `books` VALUES ('106', 'The American Journal of Politics', 'STANFORD:36105007427243', '', '0');
INSERT INTO `books` VALUES ('107', 'Lincoln and the Politics of Slavery', 'Daniel W. Crofts', '9781469627328', '0');
INSERT INTO `books` VALUES ('108', 'The Logic of Japanese Politics', 'Gerald L. Curtis', '9780231502542', '0');
INSERT INTO `books` VALUES ('109', 'Frog In My Bucket', 'Patricia Hinkel', '1477248161', '0');
INSERT INTO `books` VALUES ('110', 'Life Cycle of a Frog, The', 'Colleen Sexton', '9781612112206', '0');
INSERT INTO `books` VALUES ('111', 'Joshua the Giant Frog', '1455606820', '', '0');
INSERT INTO `books` VALUES ('112', 'G.W. Frog and the Pumpkin Patch Bandit', 'George W. Everett', '9781449746957', '0');
INSERT INTO `books` VALUES ('113', 'The Frog and the Ox', 'Phil Cummings', '9781741206043', '0');
INSERT INTO `books` VALUES ('114', 'Frog and Fly', 'Jeff Mack', '9781101644256', '0');
INSERT INTO `books` VALUES ('115', 'Frog Or Toad?', 'Melissa Stewart', '0766036820', '0');
INSERT INTO `books` VALUES ('116', 'A Frog He Would a Wooing Go', 'NYPL:33433088076777', '', '0');
INSERT INTO `books` VALUES ('117', 'The Frog in the Pond', 'Rebecca Crosdale', '9781489707635', '0');
INSERT INTO `books` VALUES ('118', 'If a Frog Had a Santa', 'Nelle Whelchel Brannen', '9781480826786', '0');
INSERT INTO `books` VALUES ('119', 'Frog Or Toad?', 'Melissa Stewart', '0766036820', '0');
INSERT INTO `books` VALUES ('120', 'Frog and Toad Together Studying the Story Elements', 'Emily R. Smith', '9781480769311', '0');
INSERT INTO `books` VALUES ('121', 'The Tale of Frankie Fox and Terry Toad', 'Hawa Mansaray', '9781491882580', '0');
INSERT INTO `books` VALUES ('122', 'Frog and Toad Together Reader Response Writing Prompts', 'Emily R. Smith', '9781480769298', '0');
INSERT INTO `books` VALUES ('123', 'Prince Charming? ...or Toad-ally Alarming?', 'Jennifer Fox', '1593598793', '0');
INSERT INTO `books` VALUES ('124', 'Raggedy Ann and the Hoppy Toad - Illustrated by Johnny Gruelle', 'Johnny Gruelle', '9781473384408', '0');
INSERT INTO `books` VALUES ('125', 'OLD TOAD FRIEND', 'GRETCHEN NYLAND', '9781493186433', '0');
INSERT INTO `books` VALUES ('126', 'When a Frog is a Frog and a Toad is a Toad', 'Don Swann II', '9781301862849', '0');
INSERT INTO `books` VALUES ('127', 'Sir Toad & Mr. Frog', 'Christine Dockrill', '9781493119431', '0');
INSERT INTO `books` VALUES ('128', 'Can You Tell a Frog from a Toad?', 'Buffy Silverman', '9780761379980', '0');
INSERT INTO `books` VALUES ('129', 'Fromont the Younger and Risler the Elder', 'Alphonse Daudet', 'STANFORD:36105048317080', '0');
INSERT INTO `books` VALUES ('137', 'Fromont the Younger and Risler the Elder', 'Alphonse Daudet', 'STANFORD:36105048317080', '0');
INSERT INTO `books` VALUES ('141', 'Fromont the Younger and Risler the Elder', 'Alphonse Daudet', 'STANFORD:36105048317080', '0');
INSERT INTO `books` VALUES ('145', 'Fromont the Younger and Risler the Elder', 'Alphonse Daudet', 'STANFORD:36105048317080', '0');
INSERT INTO `books` VALUES ('149', 'The history of the navy of the United States of America', 'James Fenimore Cooper', 'UOM:39015016754627', '0');
INSERT INTO `books` VALUES ('150', 'Louisiana purchase', 'James Kendall Hosmer', 'UOM:39015008258637', '0');
INSERT INTO `books` VALUES ('151', 'Letters from the East', 'Henry James Ross', 'UCAL:B3126366', '0');
INSERT INTO `books` VALUES ('152', 'The American Church Catholic', 'James Aaron Bolles', 'HARVARD:HNTLMA', '0');
INSERT INTO `books` VALUES ('153', 'Metric System of Weights and Measures', 'UCAL:B4252662', '', '0');
INSERT INTO `books` VALUES ('154', 'A mechanical and critical enquiry into the nature of hermaphrodites', 'James Parsons', 'UCM:5329112974', '0');
INSERT INTO `books` VALUES ('155', 'Tables for the Use of Nautical Men, Astronomers and Others', 'Olinthus Gregory', 'UVA:X001688639', '0');
INSERT INTO `books` VALUES ('156', 'The Scots Magazine', 'James Boswell', 'NYPL:33433081660072', '0');
INSERT INTO `books` VALUES ('157', 'I Recommend', 'James D. Ployhar', '1457454831', '0');
INSERT INTO `books` VALUES ('158', 'In Hope of Liberty', 'James Oliver Horton', '019535236X', '0');
INSERT INTO `books` VALUES ('159', 'Mother Goose as a Suffragette ...', 'Woman Suffrage Party', 'STANFORD:36105047179275', '0');
INSERT INTO `books` VALUES ('160', 'The Recovery of America Demonstrated to be Practicable by Great Britain, Upon Principles and Deductions', 'Man of No Party', 'OXFORD:N11718175', '0');
INSERT INTO `books` VALUES ('161', 'Free Soil, Free Speech, Free Men', 'Democratic Party (N.Y.). State Convention', 'PRNC:32101072314535', '0');
INSERT INTO `books` VALUES ('162', 'Constitution and by-laws of the Republican Party of Cook County', 'Republican Party (Cook County, Ill.)', 'UIUC:30112105204736', '0');
INSERT INTO `books` VALUES ('163', 'Harrison\'s Administration', 'Republican Party (U.S. : 1854- ). National committee, 1892', 'HARVARD:32044105500516', '0');
INSERT INTO `books` VALUES ('164', 'A Few Facts, Relating to Lagos, Abbeokuta, and Other Sections of Central Africa', 'Robert Campbell (of the Niger Valley Exploring Party.)', 'HARVARD:32044020310819', '0');
INSERT INTO `books` VALUES ('165', 'An Abstract of the Proceedings of the Antimasonic State Convention of Massachusetts', 'Antimasonic Party (Mass.). State Convention', 'UCAL:$B265831', '0');
INSERT INTO `books` VALUES ('166', 'Proceedings of the Democratic Whig National Convention', 'Whig Party (U.S.). National convention, Harrisburg', 'HARVARD:32044086268778', '0');
INSERT INTO `books` VALUES ('167', 'Campaign Text-book of the National Democratic Party, 1896', 'UOM:39015030798394', '', '0');
INSERT INTO `books` VALUES ('168', 'SIGNI', 'United Nations. Economic Commission for Europe. Working Party on Inland Water Transport', '9211169291', '0');
INSERT INTO `books` VALUES ('169', 'Procurement Management in the Supply Chain Environment', 'Zhenying Jiang', '9781911033189', '0');
INSERT INTO `books` VALUES ('170', 'Fault Diagnosis and Fault-Tolerant Control Based on Adaptive Control Approach', 'Qikun Shen', '9783319525303', '0');
INSERT INTO `books` VALUES ('171', 'Robust Adaptive Dynamic Programming', 'Yu Jiang', '9781119132653', '0');
INSERT INTO `books` VALUES ('172', 'Enlightenment in Dispute', 'Jiang Wu', '0199715408', '0');
INSERT INTO `books` VALUES ('173', 'A Confucian Constitutional Order', 'Jiang Qing', '9781400844845', '0');
INSERT INTO `books` VALUES ('174', 'Thermodynamics of Materials', 'Qing Jiang', '9783642147180', '0');
INSERT INTO `books` VALUES ('175', 'Stream Data Processing: A Quality of Service Perspective', 'Sharma Chakravarthy', '9780387710037', '0');
INSERT INTO `books` VALUES ('176', 'Electroanalytical Chemistry Research Developments', 'P. N. Jiang', '1600219276', '0');
INSERT INTO `books` VALUES ('177', 'Contexts and Dialogue', 'Tao Jiang', '9780824831066', '0');
INSERT INTO `books` VALUES ('178', 'Large Sample Techniques for Statistics', 'Jiming Jiang', '9781441968272', '0');
INSERT INTO `books` VALUES ('179', 'Procurement Management in the Supply Chain Environment', 'Zhenying Jiang', '9781911033189', '0');
INSERT INTO `books` VALUES ('180', 'Fault Diagnosis and Fault-Tolerant Control Based on Adaptive Control Approach', 'Qikun Shen', '9783319525303', '0');
INSERT INTO `books` VALUES ('181', 'Robust Adaptive Dynamic Programming', 'Yu Jiang', '9781119132653', '0');
INSERT INTO `books` VALUES ('182', 'Enlightenment in Dispute', 'Jiang Wu', '0199715408', '0');
INSERT INTO `books` VALUES ('183', 'A Confucian Constitutional Order', 'Jiang Qing', '9781400844845', '0');
INSERT INTO `books` VALUES ('184', 'Thermodynamics of Materials', 'Qing Jiang', '9783642147180', '0');
INSERT INTO `books` VALUES ('185', 'Stream Data Processing: A Quality of Service Perspective', 'Sharma Chakravarthy', '9780387710037', '0');
INSERT INTO `books` VALUES ('186', 'Electroanalytical Chemistry Research Developments', 'P. N. Jiang', '1600219276', '0');
INSERT INTO `books` VALUES ('187', 'Contexts and Dialogue', 'Tao Jiang', '9780824831066', '0');
INSERT INTO `books` VALUES ('188', 'Large Sample Techniques for Statistics', 'Jiming Jiang', '9781441968272', '0');
INSERT INTO `books` VALUES ('189', 'Wine, a poem [by J. Gay].', 'John Gay', 'OXFORD:590406873', '0');
INSERT INTO `books` VALUES ('190', 'Black Eyed Susan', 'PRNC:32101063581449', '', '0');
INSERT INTO `books` VALUES ('191', 'Uncle John\'s Flower-gatherers', 'Jane Gay Fuller', 'NYPL:33433010838856', '0');
INSERT INTO `books` VALUES ('192', 'Food', 'Kathlyn Gay', '9781512452914', '0');
INSERT INTO `books` VALUES ('193', 'Cassell\'s Shilling Cookery', 'Arthur Gay Payne', 'HARVARD:HWHL7Y', '0');
INSERT INTO `books` VALUES ('194', 'The Beggars Opera', 'John Gay', 'ONB:+Z170669505', '0');
INSERT INTO `books` VALUES ('195', 'Wine', 'John Gay', 'UOM:39015030376357', '0');
INSERT INTO `books` VALUES ('196', 'The Mohocks, a farce [signed W.B.].', 'John Gay', 'OXFORD:590406805', '0');
INSERT INTO `books` VALUES ('197', 'Fables', 'John Gay', 'STANFORD:36105048029776', '0');
INSERT INTO `books` VALUES ('198', 'Fables by John Gay, with a Life of the Author', 'John Gay', 'BML:37001102331662', '0');

-- ----------------------------
-- Table structure for `bookwithsubject`
-- ----------------------------
DROP TABLE IF EXISTS `bookwithsubject`;
CREATE TABLE `bookwithsubject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookid` int(11) NOT NULL,
  `subjectid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookwithsubject
-- ----------------------------
INSERT INTO `bookwithsubject` VALUES ('1', '88', '1');
INSERT INTO `bookwithsubject` VALUES ('2', '59', '1');
INSERT INTO `bookwithsubject` VALUES ('3', '21', '1');

-- ----------------------------
-- Table structure for `departments`
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of departments
-- ----------------------------

-- ----------------------------
-- Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `bookid` int(11) NOT NULL,
  `authority` varchar(255) NOT NULL,
  `checkdate` date NOT NULL,
  `returndate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for `staffs`
-- ----------------------------
DROP TABLE IF EXISTS `staffs`;
CREATE TABLE `staffs` (
  `id` int(11) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `birthday` date DEFAULT NULL,
  `authority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staffs
-- ----------------------------
INSERT INTO `staffs` VALUES ('20', 'admin', 'admin', null, 'staff');

-- ----------------------------
-- Table structure for `students`
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `ID` int(11) NOT NULL,
  `Firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `birthday` date DEFAULT NULL,
  `parent` varchar(255) DEFAULT NULL,
  `authority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('21', 'sDemo', 'sDemo', null, null, 'student');

-- ----------------------------
-- Table structure for `studentwithsubject`
-- ----------------------------
DROP TABLE IF EXISTS `studentwithsubject`;
CREATE TABLE `studentwithsubject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentid` int(11) NOT NULL,
  `subjectid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studentwithsubject
-- ----------------------------
INSERT INTO `studentwithsubject` VALUES ('1', '21', '1');

-- ----------------------------
-- Table structure for `subjects`
-- ----------------------------
DROP TABLE IF EXISTS `subjects`;
CREATE TABLE `subjects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subjects
-- ----------------------------
INSERT INTO `subjects` VALUES ('1', 'testS');
INSERT INTO `subjects` VALUES ('2', 'testS2');
INSERT INTO `subjects` VALUES ('3', '487');

-- ----------------------------
-- Table structure for `teachers`
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers` (
  `id` int(11) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `birthday` date DEFAULT NULL,
  `authority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachers
-- ----------------------------

-- ----------------------------
-- Table structure for `teacherwithsubject`
-- ----------------------------
DROP TABLE IF EXISTS `teacherwithsubject`;
CREATE TABLE `teacherwithsubject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherid` int(11) NOT NULL,
  `subjectid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacherwithsubject
-- ----------------------------
INSERT INTO `teacherwithsubject` VALUES ('1', '19', '1');
INSERT INTO `teacherwithsubject` VALUES ('2', '24', '3');

-- ----------------------------
-- Table structure for `testtable`
-- ----------------------------
DROP TABLE IF EXISTS `testtable`;
CREATE TABLE `testtable` (
  `name` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testtable
-- ----------------------------
INSERT INTO `testtable` VALUES ('ban', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `authority` varchar(255) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('20', 'admin', 'admin', 'staff', '0');
INSERT INTO `user` VALUES ('21', 'studentDemo', 'studentDemo', 'student', '0');
