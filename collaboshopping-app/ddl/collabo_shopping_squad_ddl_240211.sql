create table collaborative_shopping_squad.account
(
    id          int auto_increment
        primary key,
    member_id   int                                 null,
    bank_id     int                                 null,
    account_num int                                 null,
    holder      varchar(50)                         null,
    confirm_yn  varchar(1)                          null,
    main_yn     varchar(1)                          null,
    created_at  timestamp default CURRENT_TIMESTAMP null,
    updated_at  timestamp default CURRENT_TIMESTAMP null
);

create table collaborative_shopping_squad.address
(
    id           int auto_increment
        primary key,
    member_id    int                                 null,
    address_name text                                null,
    address_type varchar(50)                         null,
    sido         varchar(50)                         null,
    sigungu      varchar(100)                        null,
    sigungu_code varchar(50)                         null,
    main_yn      varchar(1)                          null,
    created_at   timestamp default CURRENT_TIMESTAMP null,
    updated_at   timestamp default CURRENT_TIMESTAMP null
);

create table collaborative_shopping_squad.bank
(
    id         int auto_increment
        primary key,
    code       varchar(10)                         null,
    name       varchar(50)                         null,
    created_at timestamp default CURRENT_TIMESTAMP null,
    updated_at timestamp default CURRENT_TIMESTAMP null
);

create table collaborative_shopping_squad.collaborator
(
    id         int auto_increment
        primary key,
    member_id  int                                 null,
    profit     int                                 null,
    created_at timestamp default CURRENT_TIMESTAMP null,
    updated_at timestamp default CURRENT_TIMESTAMP null
);

create table collaborative_shopping_squad.like_hist
(
    id              int auto_increment
        primary key,
    member_id       int                                 null,
    collaborator_id int                                 null,
    score           int                                 null,
    created_at      timestamp default CURRENT_TIMESTAMP null,
    updated_at      timestamp default CURRENT_TIMESTAMP null
);

create table collaborative_shopping_squad.member
(
    id         int auto_increment
        primary key,
    uuid       binary(16)                          null,
    email      varchar(150)                        null,
    name       varchar(50)                         null,
    pw_hash    text                                null,
    role       varchar(50)                         null,
    created_at timestamp default CURRENT_TIMESTAMP null,
    updated_at timestamp default CURRENT_TIMESTAMP null
);

create table collaborative_shopping_squad.point
(
    member_id   int                                 not null
        primary key,
    total_point int                                 null,
    created_at  timestamp default CURRENT_TIMESTAMP null,
    updated_at  timestamp default CURRENT_TIMESTAMP null
);

create table collaborative_shopping_squad.point_hist
(
    id         int auto_increment
        primary key,
    member_id  int                                 null,
    point      int                                 null,
    content    text                                null,
    created_at timestamp default CURRENT_TIMESTAMP null,
    updated_at timestamp default CURRENT_TIMESTAMP null
);

create table collaborative_shopping_squad.product
(
    id         int auto_increment
        primary key,
    created_at timestamp default CURRENT_TIMESTAMP null,
    updated_at timestamp default CURRENT_TIMESTAMP null
);

create table collaborative_shopping_squad.total_like
(
    collaborator_id int                                 not null
        primary key,
    total_score     int                                 null,
    created_at      timestamp default CURRENT_TIMESTAMP null,
    updated_at      timestamp default CURRENT_TIMESTAMP null
);

create table collaborative_shopping_squad.trade
(
    id                 int auto_increment
        primary key,
    member_id          int                                 null,
    collaborator_id    int                                 null,
    name               varchar(200)                        null,
    content            text                                null,
    per_price          int                                 null comment '개당가격',
    min_purchase_count int                                 null,
    state              varchar(50)                         null,
    origin_url         text                                null,
    created_at         timestamp default CURRENT_TIMESTAMP null,
    updated_at         timestamp default CURRENT_TIMESTAMP null
);

create table collaborative_shopping_squad.trade_detail
(
    id             int auto_increment
        primary key,
    trade_id       int                                 null,
    member_id      int                                 null,
    purchase_count int                                 null,
    created_at     timestamp default CURRENT_TIMESTAMP null,
    updated_at     timestamp default CURRENT_TIMESTAMP null
);

