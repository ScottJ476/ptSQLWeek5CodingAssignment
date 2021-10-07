use guitars;

SELECT * FROM guitars;

INSERT INTO guitars(make, model) VALUES('Gibson', 'J-45');

UPDATE guitars SET make = 'Takamine', model = 'GD20' WHERE id = 6;

DELETE FROM guitars WHERE id = 6;