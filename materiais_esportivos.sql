-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 29/11/2023 às 19:20
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `materiais_esportivos`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `produtos_nbbshop`
--

CREATE TABLE `produtos_nbbshop` (
  `Nip` int(11) NOT NULL,
  `Categoria` varchar(40) NOT NULL,
  `Nome` varchar(80) NOT NULL,
  `Preço` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `produtos_nbbshop`
--

INSERT INTO `produtos_nbbshop` (`Nip`, `Categoria`, `Nome`, `Preço`) VALUES
(1, 'Bolas', 'Bola-de-Basquete-NBB-2023', 95),
(2, 'Regatas', 'Regata-NBB-SESI-Franca-2023', 100),
(3, 'Bermudas', 'Bermuda-NBB-SESI-Franca-2023', 70),
(5, 'Tenis', 'Tenis-Vermelho-NBB', 150);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `produtos_nbbshop`
--
ALTER TABLE `produtos_nbbshop`
  ADD PRIMARY KEY (`Nip`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `produtos_nbbshop`
--
ALTER TABLE `produtos_nbbshop`
  MODIFY `Nip` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
