ALTER TABLE student ADD CONSTRAINT age_constraint CHECK (age > 20);
ALTER TABLE student ALTER COLUMN age SET DEFAULT 20;
ALTER TABLE student ADD CONSTRAINT name_unique UNIQUE (name);
ALTER TABLE student ALTER COLUMN name SET NOT NULL;

ALTER TABLE faculty ADD CONSTRAINT name_faculty_unique UNIQUE (name);
ALTER TABLE faculty ADD CONSTRAINT color_unique UNIQUE (color);


