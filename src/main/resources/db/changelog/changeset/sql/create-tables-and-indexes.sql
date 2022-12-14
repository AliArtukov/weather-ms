CREATE TABLE "city_info" (
                             "id" serial PRIMARY KEY,
                             "name" varchar(50) NOT NULL,
                             "country" varchar(50) NOT NULL
);

CREATE TABLE "weather_info" (
                                "id" serial PRIMARY KEY,
                                "date" date NOT NULL,
                                "morning" smallint NOT NULL,
                                "daytime" smallint NOT NULL,
                                "evening" smallint NOT NULL,
                                "humidity" smallint NOT NULL,
                                "wind" smallint NOT NULL,
                                "pressure" smallint NOT NULL,
                                "moon" varchar(50) NOT NULL,
                                "sunrise" varchar(5) NOT NULL,
                                "sunset" varchar(5) NOT NULL,
                                "city_id" integer NOT NULL
);

CREATE TABLE "user_info" (
                             "id" serial PRIMARY KEY,
                             "firstname" varchar(50),
                             "lastname" varchar(50),
                             "base_token" text NOT NULL
);

CREATE TABLE "user_subscription" (
                                     "id" serial PRIMARY KEY,
                                     "user_id" integer NOT NULL,
                                     "city_id" integer NOT NULL
);

ALTER TABLE "weather_info" ADD FOREIGN KEY ("city_id") REFERENCES "city_info" ("id");

ALTER TABLE "user_subscription" ADD FOREIGN KEY ("user_id") REFERENCES "user_info" ("id");

ALTER TABLE "user_subscription" ADD FOREIGN KEY ("city_id") REFERENCES "city_info" ("id");

CREATE UNIQUE INDEX ON "city_info" ("name", "country");

CREATE UNIQUE INDEX ON "user_subscription" ("user_id", "city_id");