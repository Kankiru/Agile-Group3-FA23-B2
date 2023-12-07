create database Agile
Use Agile
create table login(
ID BIGINT identity(1,1) primary key not null,
username nvarchar(10) not null,
password nvarchar(10) not null
)
create table Customer(
ID BIGINT identity(1,1) primary key not null,
makhachhang varchar(10) not null,
hotenkhachhang nvarchar(50) not null,
emailkhachhang varchar(50) not null,
sdtkhachhang varchar(50) not null,
diachikhachhang varchar(50) not null,
gioitinh int check (gioitinh = 0 or gioitinh = 1 ) not null
)
go
create table Product(
mahoa varchar(10) not null,
tenhoa varchar(10) not null,
soluong int not null,
giaban int not null,
gianhap int not null
)
create table nhanvien(
ID BIGINT identity(1,1) primary key not null,
manhanvien varchar(10) not null,
tennhanvien nvarchar(20) not null,
sdtnhanvien nvarchar(15) not null,
gioitinh int check (gioitinh = 0 or gioitinh = 1 )not null,
trangthai varchar(10) not null
)
create table invoice(
tenkhachhang nvarchar(50) not null,
tennhanvien nvarchar(20) not null,
mahoadon varchar(20) not null,
loaihoakhachmua nvarchar(20) not null,
soluong int not null,
tienthanhtoan int not null,
)
go
select ID,makhachhang,hotenkhachhang,emailkhachhang,sdtkhachhang,diachikhachhang,gioitinh from Customer
Insert into Customer(makhachhang,hotenkhachhang,emailkhachhang,sdtkhachhang,diachikhachhang,gioitinh) values (?,?,?,?,?,?)
delete from Customer where makhachhang like ?
update Customer set hotenkhachhang= ? , emailkhachhang =? , sdtkhachhang = ? , diachikhachhang = ? ,gioitinh = ? where makhachhang like ?
select username,password from login
select mahoa,tenhoa,soluong,giaban,gianhap from Product
Insert into Product(mahoa,tenhoa,soluong,giaban,gianhap) values (?,?,?,?,?)
Delete from Product where mahoa like ?
insert into login(username,password) values (?,?)
Drop table invoice
