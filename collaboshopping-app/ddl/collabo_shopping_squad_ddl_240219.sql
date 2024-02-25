create table collaborative_shopping_squad.account
(
    id          int auto_increment
        primary key,
    member_id   int                                 null comment '멤버ID',
    bank_id     int                                 null comment '은행ID',
    account_num int                                 null comment '계좌번호',
    holder      varchar(50)                         null comment '예금주명',
    confirm_yn  varchar(1)                          null comment '계좌확인여부',
    main_yn     varchar(1)                          null comment '주계좌여부',
    created_at  timestamp default CURRENT_TIMESTAMP null comment '생성일시',
    updated_at  timestamp default CURRENT_TIMESTAMP null comment '작업일시',
    key idx_member_bank_account(member_id,bank_id,account_num)
);

create table collaborative_shopping_squad.address
(
    id           int auto_increment
        primary key,
    member_id    int                                 null comment '멤버ID',
    address_name text                                null comment '주소명',
    address_type varchar(50)                         null comment '주소유형',
    sido         varchar(50)                         null comment '시도',
    sigungu      varchar(100)                        null comment '시군구',
    sigungu_code varchar(50)                         null comment '시군구코드',
    main_yn      varchar(1)                          null comment '주배송지여부',
    created_at   timestamp default CURRENT_TIMESTAMP null comment '생성일시',
    updated_at   timestamp default CURRENT_TIMESTAMP null comment '작업일시',
    key idx_member_address(member_id,address_name)
);

create table collaborative_shopping_squad.bank
(
    id         int auto_increment
        primary key,
    code       varchar(10)                         null comment '은행코드',
    name       varchar(50)                         null comment '은행명',
    created_at timestamp default CURRENT_TIMESTAMP null comment '생성일시',
    updated_at timestamp default CURRENT_TIMESTAMP null comment '작업일시',
    key idx_code(code)
);

create table collaborative_shopping_squad.collaborator
(
    id         int auto_increment
        primary key,
    member_id  int                                 null comment '멤버ID',
    profit     int                                 null comment '수익',
    created_at timestamp default CURRENT_TIMESTAMP null comment '생성일시',
    updated_at timestamp default CURRENT_TIMESTAMP null comment '작업일시',
    key idx_member_id(member_id)
);

create table collaborative_shopping_squad.like_hist
(
    id              int auto_increment
        primary key,
    member_id       int                                 null comment '멤버ID',
    collaborator_id int                                 null comment '협력자ID',
    score           int                                 null comment '평점',
    created_at      timestamp default CURRENT_TIMESTAMP null comment '생성일시',
    updated_at      timestamp default CURRENT_TIMESTAMP null comment '작업일시',
    key idx_member_collaborator(member_id,collaborator_id)
);

create table collaborative_shopping_squad.member
(
    id         int auto_increment
        primary key,
    uuid       binary(16)                          null comment '유저ID',
    email      varchar(150)                        null comment '이메일',
    name       varchar(50)                         null comment '이름',
    pw_hash    text                                null comment '비밀번호',
    role       varchar(50)                         null comment '역할',
    created_at timestamp default CURRENT_TIMESTAMP null comment '생성일시',
    updated_at timestamp default CURRENT_TIMESTAMP null comment '작업일시',
    key idx_email(email)
);

create table collaborative_shopping_squad.point
(
    member_id   int                                 not null
        primary key,
    total_point int                                 null comment '누적포인트',
    created_at  timestamp default CURRENT_TIMESTAMP null comment '생성일시',
    updated_at  timestamp default CURRENT_TIMESTAMP null comment '작업일시'

);

create table collaborative_shopping_squad.point_hist
(
    id         int auto_increment
        primary key,
    member_id  int                                 null comment '멤버ID',
    point      int                                 null comment '포인트',
    content    text                                null comment '포인트적요',
    created_at timestamp default CURRENT_TIMESTAMP null comment '생성일시',
    updated_at timestamp default CURRENT_TIMESTAMP null comment '작업일시',
    key idx_member_id(member_id)
);

create table collaborative_shopping_squad.product
(
    id         int auto_increment
        primary key,
    created_at timestamp default CURRENT_TIMESTAMP null comment '생성일시',
    updated_at timestamp default CURRENT_TIMESTAMP null comment '작업일시'
);

create table collaborative_shopping_squad.total_like
(
    collaborator_id int                                 not null
        primary key,
    total_score     int                                 null comment '누적평점',
    created_at      timestamp default CURRENT_TIMESTAMP null comment '생성일시',
    updated_at      timestamp default CURRENT_TIMESTAMP null comment '작업일시'
);

create table collaborative_shopping_squad.trade
(
    id                 int auto_increment
        primary key,
    member_id          int                                 null comment '멤버ID',
    collaborator_id    int                                 null comment '협력자ID',
    title              varchar(200)                        null comment '공동구매제목',
    content            text                                null comment '공동구매내용',
    per_price          int                                 null comment '개당가격',
    min_purchase_count int                                 null comment '최소주문개수(거래가성사되기위한)',
    state              varchar(50)                         null comment '공동구매상태',
    origin_url         text                                null comment '공동구매본url',
    created_at         timestamp default CURRENT_TIMESTAMP null comment '생성일시',
    updated_at         timestamp default CURRENT_TIMESTAMP null comment '작업일시',
    key idx_member_collaborator(member_id,collaborator_id)
);

create table collaborative_shopping_squad.trade_detail
(
    id             int auto_increment
        primary key,
    trade_id       int                                 null comment '공동구매ID',
    member_id      int                                 null comment '멤버ID',
    purchase_count int                                 null comment '구매개수',
    created_at     timestamp default CURRENT_TIMESTAMP null comment '생성일시',
    updated_at     timestamp default CURRENT_TIMESTAMP null comment '작업일시',
    key idx_trade_member(trade_id,member_id)
);

