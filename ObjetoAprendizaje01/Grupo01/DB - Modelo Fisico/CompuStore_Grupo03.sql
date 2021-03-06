USE [CompuStore_Grupo03]
GO
/****** Object:  User [java]    Script Date: 19/07/2016 20:27:44 ******/
CREATE USER [java] FOR LOGIN [java] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [java]
GO
/****** Object:  Table [dbo].[Tbl_Categoria]    Script Date: 19/07/2016 20:27:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Tbl_Categoria](
	[idcat] [int] NOT NULL,
	[nombre] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Tbl_Categoria] PRIMARY KEY CLUSTERED 
(
	[idcat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Tbl_DescuentoCliente]    Script Date: 19/07/2016 20:27:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tbl_DescuentoCliente](
	[IdDescunto] [int] NOT NULL,
	[IdCliente] [int] NULL,
	[TipoDescuento] [int] NULL,
	[Descuento] [numeric](10, 2) NULL,
	[Estado] [int] NULL,
 CONSTRAINT [PK_Tbl_DescuentoCliente] PRIMARY KEY CLUSTERED 
(
	[IdDescunto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tbl_DetalleVenta]    Script Date: 19/07/2016 20:27:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tbl_DetalleVenta](
	[iddetalle] [int] NOT NULL,
	[idventa] [int] NOT NULL,
	[idprod] [int] NOT NULL,
	[cant] [numeric](18, 0) NOT NULL,
	[precio] [numeric](10, 2) NOT NULL,
	[subtotal] [numeric](10, 2) NULL,
 CONSTRAINT [PK_Tbl_DetalleVenta] PRIMARY KEY CLUSTERED 
(
	[iddetalle] ASC,
	[idventa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tbl_Pago]    Script Date: 19/07/2016 20:27:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Tbl_Pago](
	[idpago] [int] NOT NULL,
	[idventa] [int] NOT NULL,
	[idtipo] [int] NOT NULL,
	[detalle] [varchar](100) NOT NULL,
	[importe] [numeric](10, 2) NOT NULL,
	[obs] [varchar](1000) NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Tbl_Producto]    Script Date: 19/07/2016 20:27:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Tbl_Producto](
	[idprod] [int] NOT NULL,
	[idcat] [int] NOT NULL,
	[nombre] [varchar](100) NOT NULL,
	[precio] [numeric](10, 2) NOT NULL,
	[stock] [int] NOT NULL,
 CONSTRAINT [PK_TblProducto] PRIMARY KEY CLUSTERED 
(
	[idprod] ASC,
	[idcat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Tbl_Promociones]    Script Date: 19/07/2016 20:27:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Tbl_Promociones](
	[IdPromocion] [int] NULL,
	[Nombre] [varchar](50) NULL,
	[Descuento] [numeric](10, 2) NULL,
	[Estado] [int] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Tbl_PromocionesProducto]    Script Date: 19/07/2016 20:27:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tbl_PromocionesProducto](
	[IdPromocion] [int] NULL,
	[idProducto] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tbl_TipoPago]    Script Date: 19/07/2016 20:27:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Tbl_TipoPago](
	[idtipo] [int] NOT NULL,
	[nombre] [varchar](50) NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Tbl_Usuario]    Script Date: 19/07/2016 20:27:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Tbl_Usuario](
	[idemp] [int] NOT NULL,
	[usuario] [varchar](20) NULL,
	[clave] [varchar](200) NULL,
	[estado] [smallint] NULL,
 CONSTRAINT [PK_Usuario] PRIMARY KEY CLUSTERED 
(
	[idemp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Tbl_Venta]    Script Date: 19/07/2016 20:27:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Tbl_Venta](
	[idventa] [int] NOT NULL,
	[idemp] [int] NOT NULL,
	[cliente] [varchar](100) NOT NULL,
	[fecha] [datetime] NOT NULL,
	[importe] [numeric](10, 2) NOT NULL,
 CONSTRAINT [PK_Tbl_Venta] PRIMARY KEY CLUSTERED 
(
	[idventa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
