INSERT INTO public.user_info (firstname, lastname, base_token) VALUES ('Ali', null, 'QWxpOnBhc3N3b3Jk');
INSERT INTO public.user_info (firstname, lastname, base_token) VALUES ('Sanjar', null, 'U2FuamFyOnBhc3N3b3Jk');

INSERT INTO public.city_info (name, country, enabled) VALUES ('Tashkent', 'Uzbekistan', true);
INSERT INTO public.city_info (name, country, enabled) VALUES ('Samarkand', 'Uzbekistan', true);
INSERT INTO public.city_info (name, country, enabled) VALUES ('Bukhara', 'Uzbekistan', true);
INSERT INTO public.city_info (name, country, enabled) VALUES ('Andijan', 'Uzbekistan', false);

INSERT INTO public.user_subscription (user_id, city_id) VALUES (1, 1);
INSERT INTO public.user_subscription (user_id, city_id) VALUES (2, 1);
INSERT INTO public.user_subscription (user_id, city_id) VALUES (1, 2);

INSERT INTO public.weather_info (date, morning, daytime, evening, humidity, wind, pressure, moon, sunrise, sunset, city_id)
VALUES ('2022-12-14', 0, 3, 2, 77, 240, 770, 'Waning moon', '07:40', '16:54', 1);
INSERT INTO public.weather_info (date, morning, daytime, evening, humidity, wind, pressure, moon, sunrise, sunset, city_id)
VALUES ('2022-12-14', -1, 3, 1, 78, 250, 770, 'Waning moon', '07:35', '16:50', 2);
INSERT INTO public.weather_info (date, morning, daytime, evening, humidity, wind, pressure, moon, sunrise, sunset, city_id)
VALUES ('2022-12-14', -2, 4, 2, 75, 260, 780, 'Waning moon', '07:38', '16:56', 3);