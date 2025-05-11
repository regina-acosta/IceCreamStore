CREATE TABLE customer (
                          id UUID PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL UNIQUE,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
);

CREATE TABLE flavors (
                          id UUID PRIMARY KEY,
                          name VARCHAR(100) NOT NULL UNIQUE,
                          description TEXT,
                          status VARCHAR(20) CHECK (status IN ('ACTIVE', 'INACTIVE')) DEFAULT 'ACTIVE',
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
);

CREATE TABLE purchase (
                          id UUID PRIMARY KEY,
                          customer_id UUID NOT NULL,
                          flavor_id UUID NOT NULL,
                          purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          quantity INT NOT NULL,
                          total_price DECIMAL(5, 2) NOT NULL, -- price at time of purchase
                          CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer(id),
                          CONSTRAINT fk_flavor FOREIGN KEY (flavor_id) REFERENCES flavors(id),
);

Create TABLE monthly_menu (
                          id UUID PRIMARY KEY,
                          menu_month INT NOT NULL CHECK (menu_month BETWEEN 1 AND 12),
                          menu_year INT NOT NULL,
                          unit_price DECIMAL(5, 2) NOT NULL,
                          rank_score INT NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          flavor_id UUID NOT NULL,
                          CONSTRAINT fk_flavor FOREIGN KEY (flavor_id) REFERENCES flavors(id),
                        -- Prevent duplicates for same flavor in the same month
                          CONSTRAINT unique_flavor_per_month UNIQUE (flavor_id, menu_month, menu_year)
);

CREATE TABLE vote (
                          id UUID PRIMARY KEY,
                          customer_id UUID NOT NULL,
                          flavor_id UUID NOT NULL,
                          vote_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          vote_month INT NOT NULL CHECK (vote_month BETWEEN 1 AND 12),
                          vote_year INT NOT NULL,
                          CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer(id),
                          CONSTRAINT fk_flavor FOREIGN KEY (flavor_id) REFERENCES flavors(id),
                          -- Prevent multiple votes for the same flavor by the same customer in the same month and year
                          CONSTRAINT unique_vote UNIQUE (customer_id, flavor_id, vote_month, vote_year)
);