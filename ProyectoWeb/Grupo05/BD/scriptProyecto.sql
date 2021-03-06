USE [master]
GO
/****** Object:  Database [WilsonStore]    Script Date: 11/08/2016 19:54:09 ******/
CREATE DATABASE [WilsonStore]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'WilsonStore', FILENAME = N'C:\sql\MSSQL12.MSSQLSERVER\MSSQL\DATA\WilsonStore.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'WilsonStore_log', FILENAME = N'C:\sql\MSSQL12.MSSQLSERVER\MSSQL\DATA\WilsonStore_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
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
/****** Object:  Table [dbo].[Categorias]    Script Date: 11/08/2016 19:54:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Categorias](
	[idCategoria] [int] IDENTITY(1,1) NOT NULL,
	[NombreCategoria] [varchar](250) NULL,
	[Estado] [char](1) NULL,
 CONSTRAINT [PK_Categorias] PRIMARY KEY CLUSTERED 
(
	[idCategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ClientePromocion]    Script Date: 11/08/2016 19:54:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ClientePromocion](
	[Cliente] [int] NULL,
	[Promocion] [int] NULL,
	[Producto] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Clientes]    Script Date: 11/08/2016 19:54:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Clientes](
	[idCliente] [int] NOT NULL,
	[Nombres] [varchar](200) NULL,
	[tipodoc] [int] NULL,
	[nrodoc] [varchar](20) NULL,
	[Estado] [char](1) NULL,
	[correo] [varchar](100) NULL,
	[Telefono] [varchar](50) NULL,
	[ApellidoPaterno] [varchar](100) NULL,
	[ApellidoMaterno] [varchar](100) NULL,
	[NombreCompleto] [varchar](200) NULL,
 CONSTRAINT [PK_Clientes] PRIMARY KEY CLUSTERED 
(
	[idCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ProductoPromocion]    Script Date: 11/08/2016 19:54:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ProductoPromocion](
	[Promocion] [int] NULL,
	[Producto] [int] NULL,
	[Estado] [char](1) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Productos]    Script Date: 11/08/2016 19:54:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
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

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Promociones]    Script Date: 11/08/2016 19:54:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
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

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TipoPromocion]    Script Date: 11/08/2016 19:54:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TipoPromocion](
	[idTipoPromocion] [int] IDENTITY(1,1) NOT NULL,
	[NombrePromocion] [varchar](100) NULL,
	[Estado] [char](1) NULL,
 CONSTRAINT [PK_TipoPromocion] PRIMARY KEY CLUSTERED 
(
	[idTipoPromocion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Usuarios]    Script Date: 11/08/2016 19:54:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
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

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Ventas]    Script Date: 11/08/2016 19:54:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
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

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Clientes] ([idCliente], [Nombres], [tipodoc], [nrodoc], [Estado], [correo], [Telefono], [ApellidoPaterno], [ApellidoMaterno], [NombreCompleto]) VALUES (1, N'Milett', 1, N'10205040', N'A', N'milechi@cucardas.com', N'2544775', N'Figueroa', N'De Bocanegra', N'Milet Figueroa de Bocanegra')
INSERT [dbo].[Clientes] ([idCliente], [Nombres], [tipodoc], [nrodoc], [Estado], [correo], [Telefono], [ApellidoPaterno], [ApellidoMaterno], [NombreCompleto]) VALUES (2, N'Dorita', 1, N'20504050', N'A', N'dorita@agarrabien.net', N'4125566', N'Orbegozo', N'De Bocanegra', N'Dorita Orbegozo de Bocanegra')
INSERT [dbo].[Clientes] ([idCliente], [Nombres], [tipodoc], [nrodoc], [Estado], [correo], [Telefono], [ApellidoPaterno], [ApellidoMaterno], [NombreCompleto]) VALUES (3, N'Monique', NULL, NULL, NULL, NULL, NULL, N'Pardo', N'De Padilla', NULL)
INSERT [dbo].[Clientes] ([idCliente], [Nombres], [tipodoc], [nrodoc], [Estado], [correo], [Telefono], [ApellidoPaterno], [ApellidoMaterno], [NombreCompleto]) VALUES (4, N'Carlos', NULL, NULL, NULL, NULL, NULL, N'Lopez', N'Guevara', NULL)
INSERT [dbo].[Clientes] ([idCliente], [Nombres], [tipodoc], [nrodoc], [Estado], [correo], [Telefono], [ApellidoPaterno], [ApellidoMaterno], [NombreCompleto]) VALUES (5, N'Zorro', NULL, NULL, NULL, NULL, NULL, N'Zupe', N'Zupe', NULL)
INSERT [dbo].[Clientes] ([idCliente], [Nombres], [tipodoc], [nrodoc], [Estado], [correo], [Telefono], [ApellidoPaterno], [ApellidoMaterno], [NombreCompleto]) VALUES (6, N'Roger', NULL, NULL, NULL, NULL, NULL, N'Rambo', N'Lopez', NULL)
INSERT [dbo].[Clientes] ([idCliente], [Nombres], [tipodoc], [nrodoc], [Estado], [correo], [Telefono], [ApellidoPaterno], [ApellidoMaterno], [NombreCompleto]) VALUES (7, N'Clara', NULL, NULL, NULL, NULL, NULL, N'Fernandez', N'Regar', NULL)
INSERT [dbo].[Clientes] ([idCliente], [Nombres], [tipodoc], [nrodoc], [Estado], [correo], [Telefono], [ApellidoPaterno], [ApellidoMaterno], [NombreCompleto]) VALUES (8, N'Arturo', NULL, NULL, NULL, NULL, NULL, N'Jurado', N'Franco', NULL)
INSERT [dbo].[Usuarios] ([LoginUsuario], [Contrasenia], [Nombres], [Apellidos], [Area]) VALUES (N'cbocanegra', 0x02003EDE3CCC04F027073884E1DB417A05CC9E887FF3FE6FF8747E78A12608893A10B6BBF097131B49681F3D307BE9D7F664BB2D22834CF574EC32DDE89A09DE86D19CDAF700, N'CESAR', N'BOCANEGRA', N'SISTEMAS')
INSERT [dbo].[Usuarios] ([LoginUsuario], [Contrasenia], [Nombres], [Apellidos], [Area]) VALUES (N'PEDROP', 0x0200A337BD25DD15CB35B3F2BAA584BD6F5587939F77492D60A02349AD5633372C250FBC9992FEA877A4451BD2637F29C9AA1AE0D6956802C384CC551BB7A1A1050C655F4D07, N'PEDRO', N'PADILLA', N'CONTABILIDAD')
INSERT [dbo].[Usuarios] ([LoginUsuario], [Contrasenia], [Nombres], [Apellidos], [Area]) VALUES (N'ricardo.tafur', 0x020088173B6DFEB6984961B1DCE980FA5DAE4B116D85B81469C1849682A6EA0DE734AA7B5667236D19715A14E41F030C78CDB6CA921F203A1A7D628A13725100F9995F07533D, N'Ricardo', N'Tafur', N'SISTEMAS')
ALTER TABLE [dbo].[ClientePromocion]  WITH CHECK ADD  CONSTRAINT [FK_ClientePromocion_Clientes] FOREIGN KEY([Cliente])
REFERENCES [dbo].[Clientes] ([idCliente])
GO
ALTER TABLE [dbo].[ClientePromocion] CHECK CONSTRAINT [FK_ClientePromocion_Clientes]
GO
ALTER TABLE [dbo].[ClientePromocion]  WITH CHECK ADD  CONSTRAINT [FK_ClientePromocion_Productos] FOREIGN KEY([Producto])
REFERENCES [dbo].[Productos] ([idProducto])
GO
ALTER TABLE [dbo].[ClientePromocion] CHECK CONSTRAINT [FK_ClientePromocion_Productos]
GO
ALTER TABLE [dbo].[ClientePromocion]  WITH CHECK ADD  CONSTRAINT [FK_ClientePromocion_Promociones] FOREIGN KEY([Promocion])
REFERENCES [dbo].[Promociones] ([idPromocion])
GO
ALTER TABLE [dbo].[ClientePromocion] CHECK CONSTRAINT [FK_ClientePromocion_Promociones]
GO
ALTER TABLE [dbo].[ProductoPromocion]  WITH CHECK ADD  CONSTRAINT [FK_ProductoPromocion_Productos] FOREIGN KEY([Producto])
REFERENCES [dbo].[Productos] ([idProducto])
GO
ALTER TABLE [dbo].[ProductoPromocion] CHECK CONSTRAINT [FK_ProductoPromocion_Productos]
GO
ALTER TABLE [dbo].[ProductoPromocion]  WITH CHECK ADD  CONSTRAINT [FK_ProductoPromocion_Promociones] FOREIGN KEY([Promocion])
REFERENCES [dbo].[Promociones] ([idPromocion])
GO
ALTER TABLE [dbo].[ProductoPromocion] CHECK CONSTRAINT [FK_ProductoPromocion_Promociones]
GO
ALTER TABLE [dbo].[Productos]  WITH CHECK ADD  CONSTRAINT [FK_Productos_Categorias] FOREIGN KEY([Categoria])
REFERENCES [dbo].[Categorias] ([idCategoria])
GO
ALTER TABLE [dbo].[Productos] CHECK CONSTRAINT [FK_Productos_Categorias]
GO
ALTER TABLE [dbo].[Promociones]  WITH CHECK ADD  CONSTRAINT [FK_Promociones_TipoPromocion] FOREIGN KEY([TipoPromocion])
REFERENCES [dbo].[TipoPromocion] ([idTipoPromocion])
GO
ALTER TABLE [dbo].[Promociones] CHECK CONSTRAINT [FK_Promociones_TipoPromocion]
GO
ALTER TABLE [dbo].[Ventas]  WITH CHECK ADD  CONSTRAINT [FK_Ventas_Clientes] FOREIGN KEY([Cliente])
REFERENCES [dbo].[Clientes] ([idCliente])
GO
ALTER TABLE [dbo].[Ventas] CHECK CONSTRAINT [FK_Ventas_Clientes]
GO
ALTER TABLE [dbo].[Ventas]  WITH CHECK ADD  CONSTRAINT [FK_Ventas_Usuarios] FOREIGN KEY([Usuario])
REFERENCES [dbo].[Usuarios] ([LoginUsuario])
GO
ALTER TABLE [dbo].[Ventas] CHECK CONSTRAINT [FK_Ventas_Usuarios]
GO
/****** Object:  StoredProcedure [dbo].[ValidarLogin]    Script Date: 11/08/2016 19:54:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[ValidarLogin]
	@usuario varchar(30),
	@contraseina varchar(50)
as
begin
	declare @hashpassword varbinary(max)

	select @hashpassword=d.Contrasenia from Usuarios d where d.LoginUsuario=@usuario
	--print @hashpassword
	select PWDCOMPARE(@contraseina, @hashpassword) as RESULTADO;

end 
GO
USE [master]
GO
ALTER DATABASE [WilsonStore] SET  READ_WRITE 
GO
