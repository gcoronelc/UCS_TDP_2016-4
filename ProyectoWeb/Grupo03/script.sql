USE [master]
GO
/****** Object:  Database [wilson]    Script Date: 08/09/2016 21:31:32 ******/
CREATE DATABASE [wilson] ON  PRIMARY 
( NAME = N'wilson', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\wilson.mdf' , SIZE = 2304KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'wilson_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\wilson_log.LDF' , SIZE = 576KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [wilson] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [wilson].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [wilson] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [wilson] SET ANSI_NULLS OFF
GO
ALTER DATABASE [wilson] SET ANSI_PADDING OFF
GO
ALTER DATABASE [wilson] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [wilson] SET ARITHABORT OFF
GO
ALTER DATABASE [wilson] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [wilson] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [wilson] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [wilson] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [wilson] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [wilson] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [wilson] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [wilson] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [wilson] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [wilson] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [wilson] SET  ENABLE_BROKER
GO
ALTER DATABASE [wilson] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [wilson] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [wilson] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [wilson] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [wilson] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [wilson] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [wilson] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [wilson] SET  READ_WRITE
GO
ALTER DATABASE [wilson] SET RECOVERY FULL
GO
ALTER DATABASE [wilson] SET  MULTI_USER
GO
ALTER DATABASE [wilson] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [wilson] SET DB_CHAINING OFF
GO
EXEC sys.sp_db_vardecimal_storage_format N'wilson', N'ON'
GO
USE [wilson]
GO
/****** Object:  Table [dbo].[tp_usuario]    Script Date: 08/09/2016 21:31:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tp_usuario](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tp_producto]    Script Date: 08/09/2016 21:31:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tp_producto](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tp_cliente]    Script Date: 08/09/2016 21:31:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tp_cliente](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](30) NULL,
	[descuento] [decimal](18, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[producto]    Script Date: 08/09/2016 21:31:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[producto](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[tp_producto] [int] NULL,
	[nombre] [varchar](100) NULL,
	[precio] [real] NULL,
	[descripcion] [text] NULL,
	[stock] [int] NULL,
	[stock_min] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[cliente]    Script Date: 08/09/2016 21:31:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[cliente](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[usuario] [varchar](20) NULL,
	[contra] [varchar](20) NULL,
	[tp_cliente] [int] NULL,
	[nombre] [varchar](20) NULL,
	[paterno] [varchar](20) NULL,
	[materno] [varchar](20) NULL,
	[dni] [varchar](8) NULL,
	[email] [varchar](50) NULL,
	[direccion] [varchar](50) NULL,
	[ciudad] [varchar](10) NULL,
	[telefono] [varchar](10) NULL,
	[codigo] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[usuario] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[usuario]    Script Date: 08/09/2016 21:31:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[usuario](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[usuario] [varchar](20) NULL,
	[contra] [varbinary](8000) NULL,
	[nombre] [varchar](100) NULL,
	[tp_user] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[usuario] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[venta]    Script Date: 08/09/2016 21:31:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[venta](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[is_cliente] [int] NULL,
	[fecha] [date] NULL,
	[is_usuario_reg] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cliente_tpprod]    Script Date: 08/09/2016 21:31:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[cliente_tpprod](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_cliente] [int] NULL,
	[tp_producto] [int] NULL,
	[descuento] [decimal](3, 2) NULL,
	[motivo] [varchar](100) NULL,
	[fec_ini] [date] NULL,
	[fec_fin] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  StoredProcedure [dbo].[cliente_ist]    Script Date: 08/09/2016 21:31:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[cliente_ist]
@nombre	varchar(20),
@paterno varchar(20),
@materno varchar(20),
@dni varchar(8),
@email varchar(50),
@dir varchar(50),
@ciudad varchar(10),
@tel varchar(10),
@codigo varchar(10)
as
declare @cont int

set @cont=(select count(id) from cliente where dni=@dni)
if @cont=0 
begin
	insert into cliente(nombre,paterno,materno,dni,email,direccion,ciudad,telefono,codigo,tp_cliente)
	values(@nombre,@paterno,@materno,@dni,@email,@dir,@ciudad,@tel,@codigo,1)
	return select 1 as res
end
else
begin
	return select 0 as res
end
GO
/****** Object:  Table [dbo].[venta_detalle]    Script Date: 08/09/2016 21:31:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[venta_detalle](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_venta] [int] NULL,
	[id_producto] [int] NULL,
	[cantidad] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Default [DF__producto__stock__3A81B327]    Script Date: 08/09/2016 21:31:33 ******/
ALTER TABLE [dbo].[producto] ADD  DEFAULT ((0)) FOR [stock]
GO
/****** Object:  Default [DF__producto__stock___3B75D760]    Script Date: 08/09/2016 21:31:33 ******/
ALTER TABLE [dbo].[producto] ADD  DEFAULT ((10)) FOR [stock_min]
GO
/****** Object:  ForeignKey [FK__cliente__tp_clie__1367E606]    Script Date: 08/09/2016 21:31:33 ******/
ALTER TABLE [dbo].[cliente]  WITH CHECK ADD FOREIGN KEY([tp_cliente])
REFERENCES [dbo].[tp_cliente] ([id])
GO
/****** Object:  ForeignKey [FK__usuario__tp_user__07F6335A]    Script Date: 08/09/2016 21:31:33 ******/
ALTER TABLE [dbo].[usuario]  WITH CHECK ADD FOREIGN KEY([tp_user])
REFERENCES [dbo].[tp_usuario] ([id])
GO
/****** Object:  ForeignKey [FK__venta__is_client__267ABA7A]    Script Date: 08/09/2016 21:31:33 ******/
ALTER TABLE [dbo].[venta]  WITH CHECK ADD FOREIGN KEY([is_cliente])
REFERENCES [dbo].[cliente] ([id])
GO
/****** Object:  ForeignKey [FK__venta__is_usuari__276EDEB3]    Script Date: 08/09/2016 21:31:33 ******/
ALTER TABLE [dbo].[venta]  WITH CHECK ADD FOREIGN KEY([is_usuario_reg])
REFERENCES [dbo].[usuario] ([id])
GO
/****** Object:  ForeignKey [FK__cliente_t__id_cl__1BFD2C07]    Script Date: 08/09/2016 21:31:33 ******/
ALTER TABLE [dbo].[cliente_tpprod]  WITH CHECK ADD FOREIGN KEY([id_cliente])
REFERENCES [dbo].[cliente] ([id])
GO
/****** Object:  ForeignKey [FK__cliente_t__tp_pr__1CF15040]    Script Date: 08/09/2016 21:31:33 ******/
ALTER TABLE [dbo].[cliente_tpprod]  WITH CHECK ADD FOREIGN KEY([tp_producto])
REFERENCES [dbo].[tp_producto] ([id])
GO
/****** Object:  ForeignKey [FK__venta_det__id_pr__2D27B809]    Script Date: 08/09/2016 21:31:34 ******/
ALTER TABLE [dbo].[venta_detalle]  WITH CHECK ADD FOREIGN KEY([id_producto])
REFERENCES [dbo].[producto] ([id])
GO
/****** Object:  ForeignKey [FK__venta_det__id_ve__2C3393D0]    Script Date: 08/09/2016 21:31:34 ******/
ALTER TABLE [dbo].[venta_detalle]  WITH CHECK ADD FOREIGN KEY([id_venta])
REFERENCES [dbo].[venta] ([id])
GO
