INSERT INTO clients VALUES(1, '13965092-1', 'Alejandro', 'Arévalo');
INSERT INTO products VALUES(1, '111', 'IPhone 11 Pro Max', 750000, 10);
INSERT INTO products VALUES(2, '222', 'Cafe 100 gramos', 2500, 20);
INSERT INTO orders values(1, now(), 1);
INSERT INTO order_line values(1, 2, 750000, 1500000, 1, 1);
INSERT INTO order_line values(2, 5, 2500, 12500, 1, 2);