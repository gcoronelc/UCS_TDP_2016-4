USE [WilsonStore]
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Productos_Categorias]') AND parent_object_id = OBJECT_ID(N'[dbo].[Productos]'))
ALTER TABLE [dbo].[Productos] DROP CONSTRAINT [FK_Productos_Categorias]
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ProductoPromocion_Promociones]') AND parent_object_id = OBJECT_ID(N'[dbo].[ProductoPromocion]'))
ALTER TABLE [dbo].[ProductoPromocion] DROP CONSTRAINT [FK_ProductoPromocion_Promociones]
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ProductoPromocion_Productos]') AND parent_object_id = OBJECT_ID(N'[dbo].[ProductoPromocion]'))
ALTER TABLE [dbo].[ProductoPromocion] DROP CONSTRAINT [FK_ProductoPromocion_Productos]
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ClientePromocion_Promociones]') AND parent_object_id = OBJECT_ID(N'[dbo].[ClientePromocion]'))
ALTER TABLE [dbo].[ClientePromocion] DROP CONSTRAINT [FK_ClientePromocion_Promociones]
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ClientePromocion_Productos]') AND parent_object_id = OBJECT_ID(N'[dbo].[ClientePromocion]'))
ALTER TABLE [dbo].[ClientePromocion] DROP CONSTRAINT [FK_ClientePromocion_Productos]
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ClientePromocion_Clientes]') AND parent_object_id = OBJECT_ID(N'[dbo].[ClientePromocion]'))
ALTER TABLE [dbo].[ClientePromocion] DROP CONSTRAINT [FK_ClientePromocion_Clientes]
GO
/****** Object:  Table [dbo].[Ventas]    Script Date: 12/07/2016 08:39:23 p.m. ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Ventas]') AND type in (N'U'))
DROP TABLE [dbo].[Ventas]
GO
/****** Object:  Table [dbo].[Usuarios]    Script Date: 12/07/2016 08:39:23 p.m. ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Usuarios]') AND type in (N'U'))
DROP TABLE [dbo].[Usuarios]
GO
/****** Object:  Table [dbo].[TipoPromocion]    Script Date: 12/07/2016 08:39:23 p.m. ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TipoPromocion]') AND type in (N'U'))
DROP TABLE [dbo].[TipoPromocion]
GO
/****** Object:  Table [dbo].[Promociones]    Script Date: 12/07/2016 08:39:23 p.m. ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Promociones]') AND type in (N'U'))
DROP TABLE [dbo].[Promociones]
GO
/****** Object:  Table [dbo].[Productos]    Script Date: 12/07/2016 08:39:23 p.m. ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Productos]') AND type in (N'U'))
DROP TABLE [dbo].[Productos]
GO
/****** Object:  Table [dbo].[ProductoPromocion]    Script Date: 12/07/2016 08:39:23 p.m. ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ProductoPromocion]') AND type in (N'U'))
DROP TABLE [dbo].[ProductoPromocion]
GO
/****** Object:  Table [dbo].[Clientes]    Script Date: 12/07/2016 08:39:23 p.m. ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Clientes]') AND type in (N'U'))
DROP TABLE [dbo].[Clientes]
GO
/****** Object:  Table [dbo].[ClientePromocion]    Script Date: 12/07/2016 08:39:23 p.m. ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ClientePromocion]') AND type in (N'U'))
DROP TABLE [dbo].[ClientePromocion]
GO
/****** Object:  Table [dbo].[Categorias]    Script Date: 12/07/2016 08:39:23 p.m. ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Categorias]') AND type in (N'U'))
DROP TABLE [dbo].[Categorias]
GO
USE [master]
GO
/****** Object:  Database [WilsonStore]    Script Date: 12/07/2016 08:39:23 p.m. ******/
IF  EXISTS (SELECT name FROM sys.databases WHERE name = N'WilsonStore')
DROP DATABASE [WilsonStore]
GO
/****** Object:  Database [WilsonStore]    Script Date: 12/07/2016 08:39:23 p.m. ******/
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'WilsonStore')
BEGIN
CREATE DATABASE [WilsonStore]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'WilsonStore', FILENAME = N'C:\sql\MSSQL12.MSSQLSERVER\MSSQL\DATA\WilsonStore.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'WilsonStore_log', FILENAME = N'C:\sql\MSSQL12.MSSQLSERVER\MSSQL\DATA\WilsonStore_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
END

GO
ALTER DATABASE [WilsonStore] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [WilsonStore].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [WilsonStore] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [WilsonStore] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [WilsonStore] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [WilsonStore] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [WilsonStore] SET ARITHABORT OFF 
GO
ALTER DATABASE [WilsonStore] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [WilsonStore] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [WilsonStore] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [WilsonStore] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [WilsonStore] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [WilsonStore] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [WilsonStore] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [WilsonStore] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [WilsonStore] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [WilsonStore] SET  DISABLE_BROKER 
GO
ALTER DATABASE [WilsonStore] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [WilsonStore] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [WilsonStore] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [WilsonStore] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [WilsonStore] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [WilsonStore] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [WilsonStore] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [WilsonStore] SET RECOVERY FULL 
GO
ALTER DATABASE [WilsonStore] SET  MULTI_USER 
GO
ALTER DATABASE [WilsonStore] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [WilsonStore] SET DB_CHAINING OFF 
GO
ALTER DATABASE [WilsonStore] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [WilsonStore] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [WilsonStore] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'WilsonStore', N'ON'
GO
USE [WilsonStore]
GO
/****** Object:  Table [dbo].[Categorias]    Script Date: 12/07/2016 08:39:23 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Categorias]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Categorias](
	[idCategoria] [int] IDENTITY(1,1) NOT NULL,
	[NombreCategoria] [varchar](250) NULL,
	[Estado] [char](1) NULL,
 CONSTRAINT [PK_Categorias] PRIMARY KEY CLUSTERED 
(
	[idCategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ClientePromocion]    Script Date: 12/07/2016 08:39:24 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ClientePromocion]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ClientePromocion](
	[Cliente] [int] NULL,
	[Promocion] [int] NULL,
	[Producto] [int] NULL
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Clientes]    Script Date: 12/07/2016 08:39:24 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Clientes]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Clientes](
	[idCliente] [int] NOT NULL,
	[Nombres] [varchar](200) NULL,
	[Apellidos] [varchar](200) NULL,
	[tipodoc] [int] NULL,
	[nrodoc] [varchar](20) NULL,
	[Estado] [char](1) NULL,
	[correo] [varchar](100) NULL,
	[Telefono] [varchar](50) NULL,
 CONSTRAINT [PK_Clientes] PRIMARY KEY CLUSTERED 
(
	[idCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ProductoPromocion]    Script Date: 12/07/2016 08:39:24 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ProductoPromocion]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ProductoPromocion](
	[Promocion] [int] NULL,
	[Producto] [int] NULL,
	[Estado] [char](1) NULL,
	[TipoPromocion] [int] NULL
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Productos]    Script Date: 12/07/2016 08:39:24 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Productos]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Productos](
	[idProducto] [int] IDENTITY(1,1) NOT NULL,
	[NombreProducto] [varchar](500) NULL,
	[EstadoProducto] [char](1) NULL,
	[PrecioUnitario] [money] NULL,
	[Descripcion] [varchar](500) NULL,
	[Categoria] [int] NULL,
 CONSTRAINT [PK_Productos] PRIMARY KEY CLUSTERED 
(
	[idProducto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Promociones]    Script Date: 12/07/2016 08:39:24 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Promociones]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Promociones](
	[idPromocion] [int] NOT NULL,
	[NombrePromocion] [varchar](150) NULL,
	[Descuento] [money] NULL,
	[PrecioPromo] [money] NULL,
	[Estado] [char](1) NULL,
	[TipoPromocion] [int] NULL,
 CONSTRAINT [PK_Promociones] PRIMARY KEY CLUSTERED 
(
	[idPromocion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TipoPromocion]    Script Date: 12/07/2016 08:39:24 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[TipoPromocion]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[TipoPromocion](
	[idTipoPromocion] [int] IDENTITY(1,1) NOT NULL,
	[NombrePromocion] [varchar](100) NULL,
	[Estado] [char](1) NULL,
 CONSTRAINT [PK_TipoPromocion] PRIMARY KEY CLUSTERED 
(
	[idTipoPromocion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Usuarios]    Script Date: 12/07/2016 08:39:24 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Usuarios]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Usuarios](
	[LoginUsuario] [varchar](30) NOT NULL,
	[Contrasenia] [varbinary](max) NULL,
	[Nombres] [varchar](100) NULL,
	[Apellidos] [varchar](150) NULL,
	[Area] [varchar](50) NULL,
 CONSTRAINT [PK_Usuarios] PRIMARY KEY CLUSTERED 
(
	[LoginUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Ventas]    Script Date: 12/07/2016 08:39:24 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Ventas]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Ventas](
	[idVenta] [int] IDENTITY(1,1) NOT NULL,
	[Cliente] [int] NULL,
	[Fecha] [datetime] NULL,
	[Usuario] [varchar](30) NULL,
 CONSTRAINT [PK_Ventas] PRIMARY KEY CLUSTERED 
(
	[idVenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ClientePromocion_Clientes]') AND parent_object_id = OBJECT_ID(N'[dbo].[ClientePromocion]'))
ALTER TABLE [dbo].[ClientePromocion]  WITH CHECK ADD  CONSTRAINT [FK_ClientePromocion_Clientes] FOREIGN KEY([Cliente])
REFERENCES [dbo].[Clientes] ([idCliente])
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ClientePromocion_Clientes]') AND parent_object_id = OBJECT_ID(N'[dbo].[ClientePromocion]'))
ALTER TABLE [dbo].[ClientePromocion] CHECK CONSTRAINT [FK_ClientePromocion_Clientes]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ClientePromocion_Productos]') AND parent_object_id = OBJECT_ID(N'[dbo].[ClientePromocion]'))
ALTER TABLE [dbo].[ClientePromocion]  WITH CHECK ADD  CONSTRAINT [FK_ClientePromocion_Productos] FOREIGN KEY([Producto])
REFERENCES [dbo].[Productos] ([idProducto])
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ClientePromocion_Productos]') AND parent_object_id = OBJECT_ID(N'[dbo].[ClientePromocion]'))
ALTER TABLE [dbo].[ClientePromocion] CHECK CONSTRAINT [FK_ClientePromocion_Productos]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ClientePromocion_Promociones]') AND parent_object_id = OBJECT_ID(N'[dbo].[ClientePromocion]'))
ALTER TABLE [dbo].[ClientePromocion]  WITH CHECK ADD  CONSTRAINT [FK_ClientePromocion_Promociones] FOREIGN KEY([Promocion])
REFERENCES [dbo].[Promociones] ([idPromocion])
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ClientePromocion_Promociones]') AND parent_object_id = OBJECT_ID(N'[dbo].[ClientePromocion]'))
ALTER TABLE [dbo].[ClientePromocion] CHECK CONSTRAINT [FK_ClientePromocion_Promociones]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ProductoPromocion_Productos]') AND parent_object_id = OBJECT_ID(N'[dbo].[ProductoPromocion]'))
ALTER TABLE [dbo].[ProductoPromocion]  WITH CHECK ADD  CONSTRAINT [FK_ProductoPromocion_Productos] FOREIGN KEY([Producto])
REFERENCES [dbo].[Productos] ([idProducto])
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ProductoPromocion_Productos]') AND parent_object_id = OBJECT_ID(N'[dbo].[ProductoPromocion]'))
ALTER TABLE [dbo].[ProductoPromocion] CHECK CONSTRAINT [FK_ProductoPromocion_Productos]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ProductoPromocion_Promociones]') AND parent_object_id = OBJECT_ID(N'[dbo].[ProductoPromocion]'))
ALTER TABLE [dbo].[ProductoPromocion]  WITH CHECK ADD  CONSTRAINT [FK_ProductoPromocion_Promociones] FOREIGN KEY([Promocion])
REFERENCES [dbo].[Promociones] ([idPromocion])
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ProductoPromocion_Promociones]') AND parent_object_id = OBJECT_ID(N'[dbo].[ProductoPromocion]'))
ALTER TABLE [dbo].[ProductoPromocion] CHECK CONSTRAINT [FK_ProductoPromocion_Promociones]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Productos_Categorias]') AND parent_object_id = OBJECT_ID(N'[dbo].[Productos]'))
ALTER TABLE [dbo].[Productos]  WITH CHECK ADD  CONSTRAINT [FK_Productos_Categorias] FOREIGN KEY([Categoria])
REFERENCES [dbo].[Categorias] ([idCategoria])
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Productos_Categorias]') AND parent_object_id = OBJECT_ID(N'[dbo].[Productos]'))
ALTER TABLE [dbo].[Productos] CHECK CONSTRAINT [FK_Productos_Categorias]
GO
USE [master]
GO
ALTER DATABASE [WilsonStore] SET  READ_WRITE 
GO
