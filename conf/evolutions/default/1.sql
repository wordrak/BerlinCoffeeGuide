
# --- !Ups

CREATE TABLE CoffeeShop (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    modified_at TIMESTAMP NOT NULL DEFAULT NOW(),
    name TEXT NOT NULL,
    street TEXT NOT NULL,
    zipCode TEXT NOT NULL,
    city TEXT NOT NULL,

    PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE CoffeeShop;