CREATE TABLE customer (
                          id UUID PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE,
                          phone_number VARCHAR(15) UNIQUE,
                          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE flavor (
                          id UUID PRIMARY KEY,
                          flavor_name VARCHAR(100) NOT NULL UNIQUE,
                          description TEXT,
                          unit_price DECIMAL(5,2) NOT NULL,
                          status VARCHAR(20) NOT NULL CHECK (status IN ('ACTIVE', 'INACTIVE')),
                          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE purchase (
                          id UUID PRIMARY KEY,
                          customer_id UUID NOT NULL,
                          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          total_price DECIMAL(7, 2) NOT NULL CHECK (total_price >= 0),
                          CONSTRAINT fk_customer_purchase FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE purchase_item (
                               id UUID PRIMARY KEY,
                               purchase_id UUID NOT NULL,
                               flavor_id UUID NOT NULL,
                               quantity INT NOT NULL CHECK (quantity > 0),
                               unit_price DECIMAL(5, 2) NOT NULL,
                               created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                               CONSTRAINT fk_purchase FOREIGN KEY (purchase_id) REFERENCES purchase(id),
                               CONSTRAINT fk_flavor_purchase_item FOREIGN KEY (flavor_id) REFERENCES flavor(id)
);

Create TABLE menu_item (
                          id UUID PRIMARY KEY,
                          menu_month INT NOT NULL CHECK (menu_month BETWEEN 1 AND 12),
                          menu_year INT NOT NULL,
                          flavor_id UUID NOT NULL,
                          unit_price DECIMAL(5, 2) NOT NULL,
                          rank_score DECIMAL(5, 2) NOT NULL,
                          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          CONSTRAINT fk_flavor_monthly_menu FOREIGN KEY (flavor_id) REFERENCES flavor(id),
                        -- Prevent duplicates for same flavor in the same month
                          CONSTRAINT unique_flavor_per_month UNIQUE (flavor_id, menu_month, menu_year)
);

CREATE TABLE vote (
                          id UUID PRIMARY KEY,
                          customer_id UUID NOT NULL,
                          flavor_id UUID NOT NULL,
                          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          vote_month INT NOT NULL CHECK (vote_month BETWEEN 1 AND 12),
                          vote_year INT NOT NULL,
                          CONSTRAINT fk_customer_vote FOREIGN KEY (customer_id) REFERENCES customer(id),
                          CONSTRAINT fk_flavor_vote FOREIGN KEY (flavor_id) REFERENCES flavor(id),
                          -- Prevent multiple votes for the same flavor by the same customer in the same month and year
                          CONSTRAINT unique_vote UNIQUE (customer_id, flavor_id, vote_month, vote_year)
);

