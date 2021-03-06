SET SCHEMA 'dnnr';

INSERT INTO users (role, username, password)
VALUES ('User', 'Bob', '5f4dcc3b5aa765d61d8327deb882cf99'),/*password*/
       ('User', 'Hans', '23a8cadbee3c6d52a8bdc33aa962f5be'),/*fisk*/
       ('Admin', 'Admin', 'eb0a191797624dd3a48fa681d3061212'), /*master*/
       ('User', 'Superman', '6f7f9432d35dea629c8384dab312259a'), /*strong*/
       ('User', 'Superwoman', '6f7f9432d35dea629c8384dab312259a'), /*strong*/
       ('User', 'AllergyBoy', '657f8b8da628ef83cf69101b6817150a'); /*help*/

INSERT INTO recipe (name)
VALUES ('Kylling Korma'),
       ('Pandekager'),
       ('Fiskefingre'),
       ('Tarteletter'),
       ('Mexicansk Risret');

INSERT INTO ingredient (name)
VALUES ('Løg'),
       ('Hvidløg'),
       ('Gulerod'),
       ('Squash'),
       ('Chili'),
       ('Spidskommen'),
       ('Koriander'),
       ('Kanel'),
       ('Paprika'),
       ('Ris'),
       ('Grøntsagsbouillon'),
       ('Hakkede tomater'),
       ('Sorte bønner'),
       ('Majs'),
       ('Rød peberfrugt'),
       ('Cherrytomater'),
       ('Olivenolie'),
       ('Salt'),
       ('Peber'),
       ('Kyllingebryst'),
       ('Garam Masala'),
       ('Chiliflager'),
       ('Gurkemeje'),
       ('Ingefær'),
       ('Lime'),
       ('Græsk Yoghurt'),
       ('Rødløg'),
       ('Tomatpuré'),
       ('Kokosmælk'),
       ('Mandler'),
       ('Kokosolie'),
       ('Vaniljestang'),
       ('Sukker'),
       ('Kardemomme'),
       ('Æg'),
       ('Mælk'),
       ('Øl'),
       ('Hvedemel'),
       ('Smør'),
       ('Rasp'),
       ('Citron'),
       ('Persille'),
       ('Fuldkornshvedemel'),
       ('Torskefilet'),
       ('Laurbærblade'),
       ('Hvide asparges'),
       ('Tarteletskaller'),
       ('Jordnødder');

INSERT INTO unit (name)
VALUES (' '),
       ('dl'),
       ('tsk'),
       ('spsk'),
       ('gr'),
       ('håndfuld'),
       ('cl'),
       ('l'),
       ('ml'),
       ('kg'),
       ('stk'),
       ('ca'),
       ('fed'),
       ('dåse'),
       ('knivspids');

INSERT INTO recipeingredients (recipeid, ingredientid, amount, unitid)
VALUES (1, 20, 500, 5),
       (1, 21, 1, 4),
       (1, 22, 0.5, 3),
       (1, 23, 1, 3),
       (1, 2, 4, 13),
       (1, 24, 1, 4),
       (1, 25, 1, 1),
       (1, 26, 1, 2),
       (1, 27, 2, 1),
       (1, 28, 75, 5),
       (1, 29, 1, 14),
       (1, 30, 65, 5),
       (1, 18, 0, 1),
       (1, 19, 0, 1);

INSERT INTO recipeingredients (recipeid, ingredientid, amount, unitid)
VALUES (2, 32, 0.5, 1),
       (2, 33, 50, 5),
       (2, 34, 0.5, 3),
       (2, 35, 3, 1),
       (2, 36, 3, 2),
       (2, 37, 4, 4),
       (2, 28, 1, 15),
       (2, 38, 125, 5),
       (2, 39, 1, 4);

INSERT INTO recipeingredients(recipeid, ingredientid, amount, unitid)
VALUES (3, 40, 1, 2),
       (3, 41, 1, 1),
       (3, 42, 1, 4),
       (3, 35, 2, 1),
       (3, 38, 25, 5),
       (3, 43, 25, 5),
       (3, 44, 500, 5),
       (3, 18, 0, 1),
       (3, 19, 0, 1);

INSERT INTO recipeingredients(recipeid, ingredientid, amount, unitid)
VALUES (4, 20, 2, 1),
       (4, 11, 3, 2),
       (4, 3, 1, 1),
       (4, 1, 1, 1),
       (4, 45, 2, 1),
       (4, 39, 40, 5),
       (4, 38, 2, 4),
       (4, 36, 4, 2),
       (4, 46, 200, 5),
       (4, 18, 0, 1),
       (4, 19, 0, 1),
       (4, 47, 12, 11),
       (4, 42, 1, 6);

INSERT INTO recipeingredients(recipeid, ingredientid, amount, unitid)
VALUES (5, 1, 2, 1),
       (5, 2, 4, 13),
       (5, 3, 2, 1),
       (5, 4, 1, 1),
       (5, 5, 0.5, 1),
       (5, 6, 2, 3),
       (5, 7, 2, 3),
       (5, 8, 0.5, 3),
       (5, 9, 2, 3),
       (5, 10, 300, 5),
       (5, 11, 6, 2),
       (5, 12, 1, 14),
       (5, 13, 1, 14),
       (5, 14, 140, 5),
       (5, 15, 2, 1),
       (5, 16, 125, 5),
       (5, 17, 3, 4),
       (5, 18, 0, 1),
       (5, 19, 0, 1);

INSERT INTO foodgroup(name)
VALUES ('Fisk'),
       ('Skaldyr'),
       ('Mejeriprodukter'),
       ('Nødder'),
       ('Krydderurter'),
       ('Grøntsager'),
       ('Frugt'),
       ('Fjerkræ'),
       ('Kalv'),
       ('Lam'),
       ('Okse'),
       ('Svin'),
       ('Vildt'),
       ('Krydderier'),
       ('Korn'),
       ('Olie'),
       ('Bageartikler'),
       ('Alkohol'),
       ('Brød');

INSERT INTO foodgroupingredients(foodgroupid, ingredientid)
VALUES (6, 1),
       (6, 2),
       (6, 3),
       (6, 4),
       (6, 5),
       (14, 6),
       (5, 7),
       (14, 7),
       (14, 8),
       (14, 9),
       (15, 10),
       (6, 11),
       (6, 12),
       (6, 13),
       (6, 14),
       (6, 15),
       (6, 16),
       (16, 17),
       (14, 18),
       (14, 19),
       (8, 20),
       (14, 21),
       (14, 22),
       (14, 23),
       (6, 24),
       (7, 25),
       (3, 26),
       (6, 27),
       (6, 28),
       (7, 29),
       (4, 30),
       (16, 31),
       (17, 32),
       (17, 33),
       (14, 34),
       (3, 35),
       (3, 36),
       (18, 37),
       (17, 38),
       (3, 39),
       (19, 40),
       (7, 41),
       (5, 42),
       (17, 43),
       (1, 44),
       (5, 45),
       (6, 46),
       (19, 47);

INSERT INTO foodgroupallergy (userid, foodgroupid)
VALUES (1, 4),
       (6, 1),
       (6, 2),
       (6, 3),
       (6, 4),
       (6, 5),
       (6, 6),
       (6, 7),
       (6, 8),
       (6,9),
       (6,10),
       (6,11),
       (6,12),
       (6, 13),
       (6, 14),
       (6, 15),
       (6, 16),
       (6, 17),
       (6, 18),
       (6, 19);


INSERT INTO foodgroupaversion(userid, foodgroupid)
VALUES (2, 18); --Religiøst bange for alkohol

INSERT INTO ingredientallergy(userid, ingredientid)
VALUES (2, 9),
       (6, 1),
       (6, 2),
       (6, 3),
       (6, 4),
       (6, 5),
       (6, 6),
       (6, 7),
       (6, 8),
       (6,9),
       (6,10),
       (6,11),
       (6,12),
       (6, 13),
       (6, 14),
       (6, 15),
       (6, 16),
       (6, 17),
       (6, 18),
       (6, 19),
       (6, 20),
       (6, 21),
       (6, 22),
       (6, 23),
       (6, 24),
       (6, 25),
       (6, 26),
       (6, 27),
       (6, 28),
       (6,29),
       (6,30),
       (6,31),
       (6,32),
       (6, 33),
       (6, 34),
       (6, 35),
       (6, 36),
       (6, 37),
       (6, 38),
       (6, 39),
       (6, 40),
       (6, 41),
       (6, 42),
       (6, 43),
       (6, 44),
       (6, 45),
       (6, 46),
       (6, 47);

INSERT INTO ingredientaversion(userid, ingredientid)
VALUES (1, 18);

INSERT INTO colours (name)
VALUES ('Rosa'),
       ('Lysegrøn'),
       ('Brun'),
       ('Mørkegul'),
       ('Lilla'),
       ('Lysegul'),
       ('Violet'),
       ('Mørkegrøn'),
       ('Abrikosfarvet'),
       ('Bronzefarvet'),
       ('Karmin'),
       ('Karmesin'),
       ('Rosenrød'),
       ('Turkisblå'),
       ('Skarlagen'),
       ('Kobberfarvet'),
       ('Gul'),
       ('Khaki'),
       ('Beige'),
       ('Nøgen'),
       ('Indigo'),
       ('Olivengrøn'),
       ('Laksefarvet'),
       ('Himmelblå'),
       ('Ultramarin'),
       ('Chokoladefarvet'),
       ('Magenta'),
       ('Kongeblå'),
       ('Cyan'),
       ('Guld'),
       ('Pink'),
       ('Kobber'),
       ('Sølv'),
       ('Grøn'),
       ('Bordeaux'),
       ('Orange'),
       ('Blå'),
       ('Sort'),
       ('Hvid'),
       ('Rød');

INSERT INTO animals (name)
VALUES ('Agatudse'),
       ('Aguti'),
       ('Ål'),
       ('Ålekvabbe'),
       ('Alpesalamander'),
       ('And'),
       ('Anole'),
       ('Ægslange'),
       ('Æskeskildpadde'),
       ('Æskulapsnog'),
       ('Balistær'),
       ('Basilisk'),
       ('Bavian'),
       ('Bæltedyr'),
       ('Bæver'),
       ('Bæverrotte'),
       ('Bisamrotte'),
       ('Bison'),
       ('Bjergsalamander'),
       ('Bladhalegekko'),
       ('Blæksprutte'),
       ('Bramgås'),
       ('Brandmus'),
       ('Brisling'),
       ('Brosme'),
       ('Brud'),
       ('Canadagås'),
       ('Chimpanse'),
       ('Chinchilla'),
       ('Congopåfugl'),
       ('Congosnegl'),
       ('Dådyr'),
       ('Dovendyr'),
       ('Drossel'),
       ('Dværgflagermus'),
       ('Dværghjort'),
       ('Dværgsilkeabe'),
       ('Edderfugl'),
       ('Edderkopabe'),
       ('Egern'),
       ('Elefant'),
       ('Elsdyr'),
       ('Elsdyrantilope'),
       ('Emu'),
       ('Får'),
       ('Fasan'),
       ('Firben'),
       ('Fjæsing'),
       ('Flamingo'),
       ('Flodhest'),
       ('Kapivar'),
       ('Flyvende hund'),
       ('Frederik'),
       ('Frø'),
       ('Fugleedderkop'),
       ('Gaurokse'),
       ('Ged'),
       ('Gedde'),
       ('Gemse'),
       ('Genette'),
       ('Gepard'),
       ('Gibbon'),
       ('Giftfrø'),
       ('Giraf'),
       ('Glatsnog'),
       ('Gnu'),
       ('Gravand'),
       ('Græshoppe'),
       ('Grævling'),
       ('Gris'),
       ('Guanaco'),
       ('Løveabe'),
       ('Haj'),
       ('Halsbåndmus'),
       ('Hamster'),
       ('Hare'),
       ('Hasselmus'),
       ('Havål'),
       ('Havesyvsover'),
       ('Havkat'),
       ('Havørred'),
       ('Havtaske'),
       ('Hellefisk'),
       ('Helleflynder'),
       ('Helt'),
       ('Hermelin'),
       ('Hest'),
       ('Hestemakrel'),
       ('Hjorteantilope'),
       ('Hjortesvin'),
       ('Hokko'),
       ('Honningsuger'),
       ('Hornfisk'),
       ('Hornfrø'),
       ('Hornugle'),
       ('Høne'),
       ('Hugorm'),
       ('Hulepindsvin'),
       ('Hummer'),
       ('Hund'),
       ('Husmår'),
       ('Husrotte'),
       ('Husspidsmus'),
       ('Hvilling'),
       ('Hvinand'),
       ('Hyrdefugl'),
       ('Ibis'),
       ('Ilder'),
       ('Ildsalamander'),
       ('Impala'),
       ('Isbjørn'),
       ('Ising'),
       ('Javanæsehornsfugl'),
       ('Jærv'),
       ('Jomfruhummer'),
       ('Kakerlak'),
       ('Kalkun'),
       ('Kamel'),
       ('Kanin'),
       ('Karakal'),
       ('Karminbiæder'),
       ('Karpe'),
       ('Kattalemur'),
       ('Kat'),
       ('Kænguru'),
       ('Kejsertamarin'),
       ('Klyde'),
       ('Knæler'),
       ('Knurhane'),
       ('Koala'),
       ('Kobra'),
       ('Kolibri'),
       ('Kongesnog'),
       ('Konksnegl'),
       ('Krebs'),
       ('Nilkrokodille'),
       ('Krokodilvogter'),
       ('Krondyr'),
       ('Krontrane'),
       ('Kuller'),
       ('Kulmule'),
       ('Laks'),
       ('Lama'),
       ('Langøret flagermus'),
       ('Laplandsugle'),
       ('Latterfugl'),
       ('Lemming'),
       ('Leopard'),
       ('Line'),
       ('Lori'),
       ('Los'),
       ('Løgfrø'),
       ('Løve'),
       ('Lyssej'),
       ('Madagaskargekko'),
       ('Makrel'),
       ('Mara'),
       ('Maraboustork'),
       ('Mårhund'),
       ('Markmus'),
       ('Marsvin'),
       ('Mosegris'),
       ('Moskusokse'),
       ('Mørksej'),
       ('Muflon'),
       ('Muldvarp'),
       ('Murfirben'),
       ('Murmeldyr'),
       ('Mus'),
       ('Nandu'),
       ('Næsehorn'),
       ('Nøgenhalset klokkefugl'),
       ('Odder'),
       ('Okapi'),
       ('Østers'),
       ('Panda'),
       ('Papegøje'),
       ('Paryksilkeabe'),
       ('Pibeand'),
       ('Pighaj'),
       ('Pigvar'),
       ('Pindsvin'),
       ('Pingvin'),
       ('Polarræv'),
       ('Præriehund'),
       ('Prærieugle'),
       ('Pygmægås'),
       ('Rådyr'),
       ('Ravn'),
       ('Ræv'),
       ('Regnbueørred'),
       ('Rensdyr'),
       ('Rokke'),
       ('Rosenbille'),
       ('Rotte'),
       ('Rottesnog'),
       ('Rovtæge'),
       ('Rødfisk'),
       ('Rødmus'),
       ('Løvfrø'),
       ('Rødspætte'),
       ('Rødtunge'),
       ('Rørvagtel'),
       ('Rudesnog'),
       ('Sabelantilope'),
       ('Saki'),
       ('Krokodillesalamander'),
       ('Sandart'),
       ('Serval'),
       ('Sika'),
       ('Sild'),
       ('Skalle'),
       ('Skarv'),
       ('Skægfugl'),
       ('Skærising'),
       ('Skeand'),
       ('Skink'),
       ('Skorpion'),
       ('Skovmår'),
       ('Skovmus'),
       ('Skovskildpadde'),
       ('Skrubbe'),
       ('Skrubtudse'),
       ('Slethvar'),
       ('Smaragdfirben'),
       ('Snehare'),
       ('Sneugle'),
       ('Snog'),
       ('Sommerfugl'),
       ('Søløve'),
       ('Spættet sæl'),
       ('Sperling'),
       ('Spidsand'),
       ('Spidsmus'),
       ('Spidssnudet frø'),
       ('Sporeskildpadde'),
       ('Spøgelsesabe'),
       ('Springfrø'),
       ('Springhare'),
       ('Stalling'),
       ('Stefan'),
       ('Stenbider'),
       ('Stenbuk'),
       ('Stor hesteskonæse'),
       ('Stor museøre'),
       ('Vandsalamander'),
       ('Stork'),
       ('Strandsnegl'),
       ('Strandtudse'),
       ('Struds'),
       ('Suder'),
       ('Sumpskildpadde'),
       ('Syvsover'),
       ('Tapir'),
       ('Taskekrabbe'),
       ('Tiger'),
       ('Tigerpython'),
       ('Tina'),
       ('Tjur'),
       ('Tobis'),
       ('Tomatfrø'),
       ('Torsk'),
       ('Træsnog'),
       ('Troldand'),
       ('Troldkrabbe'),
       ('Trompetfugl'),
       ('Tusindben'),
       ('Ulv'),
       ('Vandbøffel'),
       ('Vandbuk'),
       ('Vandmand'),
       ('Vandrende pind'),
       ('Varan'),
       ('Vaskebjørn'),
       ('Vibe'),
       ('Vildkat'),
       ('Vildsvin'),
       ('Yakokse'),
       ('Zebra'),
       ('Zebramangust');

INSERT INTO address(streetname, housenumber, postalcode)
VALUES ('AndersAndVej', 4, 8700),
       ('AndersAndVej', 286, 8700);

INSERT INTO users (id, role, username, password)
VALUES (DEFAULT, 'Restaurateur', 'Lis', '7538ebc37ad0917853e044b9b42bd8a4') /*mad*/;

INSERT INTO restaurant(cvr, name, theme, addressid, phonenumber, ownerid)
VALUES (15, 'McDonalds', 'FastFood', 1, '+4512345678',4),
       (94, 'Noma', 'Nordisk mad', 2, '+4587654321',4),
       (86, 'McNuggets', 'Kyllingebidder', 1, '+4570121416', 7);

SELECT * FROM users WHERE role = 'Restaurateur' or role = 'User';

