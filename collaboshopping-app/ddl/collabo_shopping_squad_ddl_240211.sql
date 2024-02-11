
CREATE TABLE member (
  id INT PRIMARY KEY AUTO_INCREMENT,
  uuid BINARY(16),
  email VARCHAR(150),
  name VARCHAR(50),
  pw_hash TEXT,
  role VARCHAR(50),
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE bank (
  id INT PRIMARY KEY AUTO_INCREMENT,
  code INT,
  name VARCHAR(50),
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE account (
  id INT PRIMARY KEY AUTO_INCREMENT,
  member_id INT,
  bank_id INT,
  account_num INT,
  holder VARCHAR(50),
  confirm_yn VARCHAR(1),
  main_yn VARCHAR(1),
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE address (
  id INT PRIMARY KEY AUTO_INCREMENT,
  member_id INT,
  address_name TEXT, 
  address_type VARCHAR(50),
  sido VARCHAR(50), 
  sigungu VARCHAR(100), 
  sigungu_code VARCHAR(50), 
  main_yn VARCHAR(1),
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE collaborator (
  id INT PRIMARY KEY AUTO_INCREMENT,
  member_id INT,
  profit INT,
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE trade (
  id INT PRIMARY KEY AUTO_INCREMENT,
  register_id INT,
  collaborator_id INT,
  name VARCHAR(200),
  content TEXT,
  per_price INT,
  min_purchase_count INT,
  state VARCHAR(50),
  origin_url TEXT,
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE trade_detail (
  id INT PRIMARY KEY AUTO_INCREMENT,
  trade_id INT,
  member_id INT,
  purchase_count INT,
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE point (
  id INT PRIMARY KEY AUTO_INCREMENT,
  total_point INT,
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE point_hist (
  id INT PRIMARY KEY AUTO_INCREMENT,
  member_id INT,
  point INT,
  content TEXT,
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE total_like (
  collaborator_id INT PRIMARY KEY AUTO_INCREMENT,
  total_score INT,
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE like_hist (
  id INT PRIMARY KEY AUTO_INCREMENT,
  member_id INT,
  collaborator_id INT,
  score INT,  
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE product (
  id INT PRIMARY KEY AUTO_INCREMENT,
  created_at TIMESTAMP DEFAULT NOW(),
  updated_at TIMESTAMP DEFAULT NOW()
);

