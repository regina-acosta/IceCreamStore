-- Customers
INSERT INTO customer (id, name, email, phone_number, created_at)
VALUES
    ('00000000-0000-0000-0000-000000000001', 'Alice Smith', 'alice@example.com', '1234567890', '2025-04-05 14:20:00'),
    ('00000000-0000-0000-0000-000000000002', 'Bob Jones', 'bob@example.com', '2345678901', '2025-04-05 14:20:00'),
    ('00000000-0000-0000-0000-000000000003', 'Carol White', 'carol@example.com', '3456789012', '2025-04-05 14:20:00'),
    ('00000000-0000-0000-0000-000000000004', 'Dave Black', 'dave@example.com', '4567890123', '2025-04-05 14:20:00'),
    ('00000000-0000-0000-0000-000000000005', 'Eve Green', 'eve@example.com', '5678901234', '2025-04-05 14:20:00');


INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000000', 'Vanilla Dream', 'Vanilla Dream flavored ice cream', 5.79, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000001', 'Chocolate Heaven', 'Chocolate Heaven flavored ice cream', 4.13, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000002', 'Strawberry Burst', 'Strawberry Burst flavored ice cream', 5.28, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000003', 'Minty Chill', 'Minty Chill flavored ice cream', 6.18, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000004', 'Caramel Swirl', 'Caramel Swirl flavored ice cream', 3.55, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000005', 'Peanut Butter Crunch', 'Peanut Butter Crunch flavored ice cream', 5.82, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000006', 'Cookies and Cream', 'Cookies and Cream flavored ice cream', 7.4, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000007', 'Mango Tango', 'Mango Tango flavored ice cream', 5.85, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000008', 'Blueberry Cheesecake', 'Blueberry Cheesecake flavored ice cream', 5.96, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000009', 'Pistachio Pop', 'Pistachio Pop flavored ice cream', 7.28, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000000a', 'Raspberry Ripple', 'Raspberry Ripple flavored ice cream', 7.19, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000000b', 'Lemon Zest', 'Lemon Zest flavored ice cream', 7.35, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000000c', 'Coconut Snow', 'Coconut Snow flavored ice cream', 7.66, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000000d', 'Espresso Shot', 'Espresso Shot flavored ice cream', 5.13, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000000e', 'Salted Caramel', 'Salted Caramel flavored ice cream', 3.15, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000000f', 'Matcha Magic', 'Matcha Magic flavored ice cream', 7.61, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000010', 'Butterscotch Bliss', 'Butterscotch Bliss flavored ice cream', 4.56, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000011', 'Pumpkin Spice', 'Pumpkin Spice flavored ice cream', 6.38, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000012', 'Honey Lavender', 'Honey Lavender flavored ice cream', 3.49, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000013', 'Blackberry Cobbler', 'Blackberry Cobbler flavored ice cream', 7.75, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000014', 'Almond Delight', 'Almond Delight flavored ice cream', 7.54, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000015', 'Hazelnut Cream', 'Hazelnut Cream flavored ice cream', 5.12, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000016', 'Tiramisu Twist', 'Tiramisu Twist flavored ice cream', 5.5, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000017', 'Banana Bonanza', 'Banana Bonanza flavored ice cream', 4.58, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000018', 'Cherry Jubilee', 'Cherry Jubilee flavored ice cream', 5.93, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000019', 'Key Lime Pie', 'Key Lime Pie flavored ice cream', 5.76, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000001a', 'Ginger Snap', 'Ginger Snap flavored ice cream', 4.9, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000001b', 'Maple Pecan', 'Maple Pecan flavored ice cream', 3.82, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000001c', 'Mocha Madness', 'Mocha Madness flavored ice cream', 4.01, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000001d', 'S’mores', 'S’mores flavored ice cream', 5.11, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000001e', 'Watermelon Wave', 'Watermelon Wave flavored ice cream', 4.02, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000001f', 'Bubblegum Pop', 'Bubblegum Pop flavored ice cream', 7.84, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000020', 'Cotton Candy', 'Cotton Candy flavored ice cream', 3.57, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000021', 'Birthday Cake', 'Birthday Cake flavored ice cream', 7.21, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000022', 'Chai Spice', 'Chai Spice flavored ice cream', 6.87, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000023', 'Toffee Crunch', 'Toffee Crunch flavored ice cream', 6.93, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000024', 'Brownie Batter', 'Brownie Batter flavored ice cream', 5.02, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000025', 'Cinnamon Roll', 'Cinnamon Roll flavored ice cream', 3.25, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000026', 'Rum Raisin', 'Rum Raisin flavored ice cream', 6.91, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000027', 'Grapefruit Glow', 'Grapefruit Glow flavored ice cream', 5.97, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000028', 'Pomegranate Punch', 'Pomegranate Punch flavored ice cream', 7.33, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000029', 'Guava Glaze', 'Guava Glaze flavored ice cream', 7.02, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000002a', 'Lychee Love', 'Lychee Love flavored ice cream', 4.66, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000002b', 'Dragonfruit Daze', 'Dragonfruit Daze flavored ice cream', 6.63, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000002c', 'Avocado Chill', 'Avocado Chill flavored ice cream', 6.56, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000002d', 'Pear Vanilla', 'Pear Vanilla flavored ice cream', 4.75, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000002e', 'Apple Pie', 'Apple Pie flavored ice cream', 7.54, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000002f', 'Cranberry Cool', 'Cranberry Cool flavored ice cream', 5.73, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000030', 'Fig Fantasy', 'Fig Fantasy flavored ice cream', 5.43, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000031', 'Kiwi Burst', 'Kiwi Burst flavored ice cream', 6.26, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000032', 'Orange Creamsicle', 'Orange Creamsicle flavored ice cream', 3.89, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000033', 'White Chocolate Dream', 'White Chocolate Dream flavored ice cream', 3.71, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000034', 'Chocolate Chip', 'Chocolate Chip flavored ice cream', 4.67, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000035', 'Cappuccino Crunch', 'Cappuccino Crunch flavored ice cream', 3.83, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000036', 'Neapolitan Swirl', 'Neapolitan Swirl flavored ice cream', 6.44, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000037', 'Limeade Freeze', 'Limeade Freeze flavored ice cream', 6.36, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000038', 'Cereal Milk', 'Cereal Milk flavored ice cream', 3.49, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000039', 'Green Apple', 'Green Apple flavored ice cream', 3.71, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000003a', 'Strawberry Cheesecake', 'Strawberry Cheesecake flavored ice cream', 6.71, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000003b', 'Cherry Cola', 'Cherry Cola flavored ice cream', 3.92, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000003c', 'Red Velvet', 'Red Velvet flavored ice cream', 7.32, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000003d', 'Molasses Magic', 'Molasses Magic flavored ice cream', 3.86, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000003e', 'Cucumber Melon', 'Cucumber Melon flavored ice cream', 4.33, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000003f', 'Honeycomb', 'Honeycomb flavored ice cream', 7.92, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000040', 'Almond Joy', 'Almond Joy flavored ice cream', 7.79, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000041', 'French Vanilla', 'French Vanilla flavored ice cream', 6.4, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000042', 'Café au Lait', 'Café au Lait flavored ice cream', 5.28, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000043', 'Mint Chocolate', 'Mint Chocolate flavored ice cream', 4.23, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000044', 'Dark Chocolate Truffle', 'Dark Chocolate Truffle flavored ice cream', 3.21, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000045', 'Blue Moon', 'Blue Moon flavored ice cream', 7.92, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000046', 'Carrot Cake', 'Carrot Cake flavored ice cream', 3.55, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000047', 'Peachy Keen', 'Peachy Keen flavored ice cream', 6.01, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000048', 'Lemon Meringue', 'Lemon Meringue flavored ice cream', 4.15, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000049', 'Toasted Coconut', 'Toasted Coconut flavored ice cream', 3.09, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000004a', 'Oatmeal Cookie', 'Oatmeal Cookie flavored ice cream', 6.71, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000004b', 'Gingerbread', 'Gingerbread flavored ice cream', 5.57, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000004c', 'Eggnog', 'Eggnog flavored ice cream', 3.77, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000004d', 'Snickerdoodle', 'Snickerdoodle flavored ice cream', 7.76, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000004e', 'Vanilla Bean', 'Vanilla Bean flavored ice cream', 4.23, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000004f', 'Stracciatella', 'Stracciatella flavored ice cream', 3.38, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000050', 'Butter Pecan', 'Butter Pecan flavored ice cream', 7.98, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000051', 'Rocky Road', 'Rocky Road flavored ice cream', 7.38, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000052', 'Chocolate Fudge', 'Chocolate Fudge flavored ice cream', 4.59, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000053', 'Cocoa Crunch', 'Cocoa Crunch flavored ice cream', 5.77, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000054', 'Choco Mint Chip', 'Choco Mint Chip flavored ice cream', 6.56, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000055', 'Salted Mocha', 'Salted Mocha flavored ice cream', 7.84, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000056', 'Chocolate Marshmallow', 'Chocolate Marshmallow flavored ice cream', 4.52, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000057', 'Vanilla Caramel Swirl', 'Vanilla Caramel Swirl flavored ice cream', 3.42, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000058', 'Lemon Blueberry', 'Lemon Blueberry flavored ice cream', 6.13, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000059', 'Tropical Punch', 'Tropical Punch flavored ice cream', 3.94, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000005a', 'Cherry Blossom', 'Cherry Blossom flavored ice cream', 7.12, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000005b', 'Spiced Apple', 'Spiced Apple flavored ice cream', 3.26, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000005c', 'Cranberry Orange', 'Cranberry Orange flavored ice cream', 6.96, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000005d', 'Apricot Twist', 'Apricot Twist flavored ice cream', 6.22, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000005e', 'Raisin Rum', 'Raisin Rum flavored ice cream', 6.5, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000005f', 'Bourbon Vanilla', 'Bourbon Vanilla flavored ice cream', 3.75, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000060', 'Chocolate Orange', 'Chocolate Orange flavored ice cream', 6.14, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000061', 'Hazelnut Mocha', 'Hazelnut Mocha flavored ice cream', 5.23, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000062', 'Pumpkin Cheesecake', 'Pumpkin Cheesecake flavored ice cream', 6.2, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000063', 'Candy Cane', 'Candy Cane flavored ice cream', 5.31, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000064', 'Lime Coconut', 'Lime Coconut flavored ice cream', 5.54, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000065', 'Espresso Bean', 'Espresso Bean flavored ice cream', 7.75, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000066', 'Frozen Yogurt', 'Frozen Yogurt flavored ice cream', 7.94, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000067', 'Frozen Raspberry', 'Frozen Raspberry flavored ice cream', 4.26, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000068', 'Frozen Blueberry', 'Frozen Blueberry flavored ice cream', 6.87, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000069', 'Coconut Chocolate', 'Coconut Chocolate flavored ice cream', 3.78, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000006a', 'Cherry Almond', 'Cherry Almond flavored ice cream', 3.51, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000006b', 'Triple Chocolate', 'Triple Chocolate flavored ice cream', 6.14, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000006c', 'Black Forest', 'Black Forest flavored ice cream', 5.88, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000006d', 'Nutella Swirl', 'Nutella Swirl flavored ice cream', 6.61, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000006e', 'Honey Pistachio', 'Honey Pistachio flavored ice cream', 6.87, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000006f', 'Irish Cream', 'Irish Cream flavored ice cream', 4.53, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000070', 'Tropical Coconut', 'Tropical Coconut flavored ice cream', 6.61, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000071', 'Rose Petal', 'Rose Petal flavored ice cream', 7.66, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000072', 'Lavender Honey', 'Lavender Honey flavored ice cream', 7.9, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000073', 'Plum', 'Plum flavored ice cream', 6.08, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000074', 'Green Tea', 'Green Tea flavored ice cream', 6.79, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000075', 'Black Sesame', 'Black Sesame flavored ice cream', 7.58, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000076', 'Passionfruit', 'Passionfruit flavored ice cream', 4.88, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000077', 'Mango Coconut', 'Mango Coconut flavored ice cream', 6.49, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000078', 'Pineapple Sorbet', 'Pineapple Sorbet flavored ice cream', 4.34, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-000000000079', 'Berry Sorbet', 'Berry Sorbet flavored ice cream', 5.95, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000007a', 'Strawberry Mint', 'Strawberry Mint flavored ice cream', 4.4, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000007b', 'Chocolate Hazelnut', 'Chocolate Hazelnut flavored ice cream', 5.05, 'ACTIVE', '2025-04-05 14:20:00');
INSERT INTO flavor (id, flavor_name, description, unit_price, status, created_at) VALUES ('10000000-0000-0000-0000-00000000007c', 'Vanilla Mocha', 'Vanilla Mocha flavored ice cream', 5.86, 'ACTIVE', '2025-04-05 14:20:00');

INSERT INTO purchase (id, customer_id, total_price, created_at)
VALUES
    ('20000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000001', 12.76, '2025-04-05 14:20:00'),
    ('20000000-0000-0000-0000-000000000002', '00000000-0000-0000-0000-000000000002', 7.00, '2025-04-05 14:20:00'),
    ('20000000-0000-0000-0000-000000000003', '00000000-0000-0000-0000-000000000003', 12.00, '2025-04-05 14:20:00'),
    ('20000000-0000-0000-0000-000000000004', '00000000-0000-0000-0000-000000000004', 13.00, '2025-04-05 14:20:00'),
    ('20000000-0000-0000-0000-000000000005', '00000000-0000-0000-0000-000000000005', 5.00, '2025-04-05 14:20:00');

INSERT INTO purchase_item (id, purchase_id, flavor_id, quantity, unit_price, created_at)
VALUES
    ('30000000-0000-0000-0000-000000000001', '20000000-0000-0000-0000-000000000001', '10000000-0000-0000-0000-000000000011', 2, 5.00, '2025-04-05 14:20:00'),
    ('30000000-0000-0000-0000-000000000002', '20000000-0000-0000-0000-000000000002', '10000000-0000-0000-0000-000000000012', 1, 7.00, '2025-04-05 14:20:00'),
    ('30000000-0000-0000-0000-000000000003', '20000000-0000-0000-0000-000000000003', '10000000-0000-0000-0000-000000000013', 3, 4.00, '2025-04-05 14:20:00'),
    ('30000000-0000-0000-0000-000000000004', '20000000-0000-0000-0000-000000000004', '10000000-0000-0000-0000-000000000015', 2, 6.50, '2025-04-05 14:20:00'),
    ('30000000-0000-0000-0000-000000000005', '20000000-0000-0000-0000-000000000005', '10000000-0000-0000-0000-000000000014', 1, 5.00, '2025-04-05 14:20:00');


INSERT INTO menu_item (id, menu_month, menu_year, flavor_id, unit_price, rank_score, created_at)
VALUES
    ('40000000-0000-0000-0000-000000000001', 4, 2025, '10000000-0000-0000-0000-000000000001', 5.00, 90, '2025-04-05 14:20:00'),
    ('40000000-0000-0000-0000-000000000002', 4, 2025, '10000000-0000-0000-0000-000000000002', 6.00, 85, '2025-04-05 14:20:00'),
    ('40000000-0000-0000-0000-000000000003', 4, 2025, '10000000-0000-0000-0000-000000000003', 4.50, 95, '2025-04-05 14:20:00'),
    ('40000000-0000-0000-0000-000000000004', 4, 2025, '10000000-0000-0000-0000-000000000005', 6.00, 80, '2025-04-05 14:20:00'),
    ('40000000-0000-0000-0000-000000000005', 4, 2025, '10000000-0000-0000-0000-000000000006', 4.00, 70, '2025-04-05 14:20:00'),
    ('40000000-0000-0000-0000-000000000006', 4, 2025, '10000000-0000-0000-0000-000000000007', 5.00, 90, '2025-04-05 14:20:00'),
    ('40000000-0000-0000-0000-000000000007', 4, 2025, '10000000-0000-0000-0000-000000000008', 6.00, 85, '2025-04-05 14:20:00'),
    ('40000000-0000-0000-0000-000000000008', 4, 2025, '10000000-0000-0000-0000-000000000009', 4.50, 95, '2025-04-05 14:20:00'),
    ('40000000-0000-0000-0000-000000000009', 4, 2025, '10000000-0000-0000-0000-000000000010', 6.00, 80, '2025-04-05 14:20:00'),
    ('40000000-0000-0000-0000-000000000010', 4, 2025, '10000000-0000-0000-0000-000000000029', 4.00, 70, '2025-04-05 14:20:00'),
('40000000-0000-0000-0000-000000000011', 4, 2025, '10000000-0000-0000-0000-000000000011', 5.00, 90, '2025-04-05 14:20:00'),
('40000000-0000-0000-0000-000000000012', 4, 2025, '10000000-0000-0000-0000-000000000012', 6.00, 85, '2025-04-05 14:20:00'),
('40000000-0000-0000-0000-000000000013', 4, 2025, '10000000-0000-0000-0000-000000000013', 4.50, 95, '2025-04-05 14:20:00'),
('40000000-0000-0000-0000-000000000014', 4, 2025, '10000000-0000-0000-0000-000000000015', 6.00, 80, '2025-04-05 14:20:00'),
('40000000-0000-0000-0000-000000000015', 4, 2025, '10000000-0000-0000-0000-000000000016', 4.00, 70, '2025-04-05 14:20:00'),
('40000000-0000-0000-0000-000000000016', 4, 2025, '10000000-0000-0000-0000-000000000017', 5.00, 90, '2025-04-05 14:20:00'),
('40000000-0000-0000-0000-000000000017', 4, 2025, '10000000-0000-0000-0000-000000000018', 6.00, 85, '2025-04-05 14:20:00'),
('40000000-0000-0000-0000-000000000018', 4, 2025, '10000000-0000-0000-0000-000000000019', 4.50, 95, '2025-04-05 14:20:00'),
('40000000-0000-0000-0000-000000000019', 4, 2025, '10000000-0000-0000-0000-000000000030', 6.00, 80, '2025-04-05 14:20:00'),
('40000000-0000-0000-0000-000000000020', 4, 2025, '10000000-0000-0000-0000-000000000021', 4.00, 70, '2025-04-05 14:20:00');


INSERT INTO vote (id, customer_id, flavor_id, vote_month, vote_year, created_at)
VALUES
    ('50000000-0000-0000-0000-000000000001', '00000000-0000-0000-0000-000000000001', '10000000-0000-0000-0000-000000000001', 5, 2025, '2025-04-05 14:20:00'),
    ('50000000-0000-0000-0000-000000000002', '00000000-0000-0000-0000-000000000002', '10000000-0000-0000-0000-000000000002', 5, 2025, '2025-04-05 14:20:00'),
    ('50000000-0000-0000-0000-000000000003', '00000000-0000-0000-0000-000000000003', '10000000-0000-0000-0000-000000000003', 5, 2025, '2025-04-05 14:20:00'),
    ('50000000-0000-0000-0000-000000000004', '00000000-0000-0000-0000-000000000004', '10000000-0000-0000-0000-000000000005', 5, 2025, '2025-04-05 14:20:00'),
    ('50000000-0000-0000-0000-000000000005', '00000000-0000-0000-0000-000000000005', '10000000-0000-0000-0000-000000000004', 5, 2025, '2025-04-05 14:20:00'),

('50000000-0000-0000-0000-000000000006', '00000000-0000-0000-0000-000000000001', '10000000-0000-0000-0000-000000000021', 4, 2025, '2025-04-05 14:20:00'),
('50000000-0000-0000-0000-000000000007', '00000000-0000-0000-0000-000000000002', '10000000-0000-0000-0000-000000000022', 4, 2025, '2025-04-05 14:20:00'),
('50000000-0000-0000-0000-000000000008', '00000000-0000-0000-0000-000000000003', '10000000-0000-0000-0000-000000000023', 4, 2025, '2025-04-05 14:20:00'),
('50000000-0000-0000-0000-000000000009', '00000000-0000-0000-0000-000000000004', '10000000-0000-0000-0000-000000000025', 4, 2025, '2025-04-05 14:20:00'),
('50000000-0000-0000-0000-000000000010', '00000000-0000-0000-0000-000000000005', '10000000-0000-0000-0000-000000000026', 4, 2025, '2025-04-05 14:20:00'),
('50000000-0000-0000-0000-000000000011', '00000000-0000-0000-0000-000000000001', '10000000-0000-0000-0000-000000000027', 4, 2025, '2025-04-05 14:20:00'),
('50000000-0000-0000-0000-000000000012', '00000000-0000-0000-0000-000000000002', '10000000-0000-0000-0000-000000000028', 4, 2025, '2025-04-05 14:20:00'),
('50000000-0000-0000-0000-000000000013', '00000000-0000-0000-0000-000000000003', '10000000-0000-0000-0000-000000000029', 4, 2025, '2025-04-05 14:20:00'),
('50000000-0000-0000-0000-000000000014', '00000000-0000-0000-0000-000000000004', '10000000-0000-0000-0000-000000000011', 4, 2025, '2025-04-05 14:20:00'),
('50000000-0000-0000-0000-000000000015', '00000000-0000-0000-0000-000000000005', '10000000-0000-0000-0000-000000000012', 4, 2025, '2025-04-05 14:20:00'),
('50000000-0000-0000-0000-000000000016', '00000000-0000-0000-0000-000000000001', '10000000-0000-0000-0000-000000000013', 4, 2025, '2025-04-05 14:20:00'),
('50000000-0000-0000-0000-000000000017', '00000000-0000-0000-0000-000000000002', '10000000-0000-0000-0000-000000000014', 4, 2025, '2025-04-05 14:20:00'),
('50000000-0000-0000-0000-000000000018', '00000000-0000-0000-0000-000000000003', '10000000-0000-0000-0000-000000000015', 4, 2025, '2025-04-05 14:20:00'),
('50000000-0000-0000-0000-000000000019', '00000000-0000-0000-0000-000000000004', '10000000-0000-0000-0000-000000000016', 4, 2025, '2025-04-05 14:20:00'),
('50000000-0000-0000-0000-000000000020', '00000000-0000-0000-0000-000000000005', '10000000-0000-0000-0000-000000000010', 4, 2025, '2025-04-05 14:20:00');
