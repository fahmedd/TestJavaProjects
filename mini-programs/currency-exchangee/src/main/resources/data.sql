INSERT INTO currency (SYMBOL) VALUES ('USD');
INSERT INTO currency (SYMBOL) VALUES ('GBP');
INSERT INTO currency (SYMBOL) VALUES ('EUR');
INSERT INTO currency (SYMBOL) VALUES ('JPY');


INSERT INTO exchange_rate (from_currency_id, to_currency_id, rate)
VALUES ((SELECT id FROM currency WHERE symbol='USD'),
        (SELECT id FROM currency WHERE symbol='EUR'), 0.93);

INSERT INTO exchange_rate (from_currency_id, to_currency_id, rate)
VALUES ((SELECT id FROM currency WHERE symbol='EUR'),
        (SELECT id FROM currency WHERE symbol='USD'), 1.08);



