import java.util.Set;

import com.mysql.cj.xdevapi.PreparableStatement;

public class ComandoSQL{
   public static void main(String[] args) throws Exception {
    // Testa o banco de Dados
    Conexao db1 = new Conexao();
    
   
   String sql = "create table agencia    " + 
   "(cod_agencia int primary key, " + 
   "num_agencia int not null," + 
   "nome_agencia varchar(25) not null)";

    db1.OpenDatabase();
    db1.ExecuteQuery(sql);


   sql = "create table codigo_banco " +
    "(id_cod_banco int primary key," +
    "cod_do_banco int not null," + 
    "nome_do_banco varchar(50) not null)";

   db1.OpenDatabase();
   db1.ExecuteQuery(sql);

   sql = "create table tipo_conta " + 
   "(cod_tipo_conta int primary key," + 
   "conta varchar(25) not null)";
   
   db1.OpenDatabase();
   db1.ExecuteQuery(sql);

   sql = "create table cliente " + 
   "(cod_cliente int primary key," + 
   "primeiro_nome varchar(25) not null," + 
   "sobrenome varchar(25) not null," + 
   "cep int(8) not null," + 
   "endereco varchar(50) not null," + 
   "cpf_cnpj varchar(14) not null," + 
   "telefone varchar(12) not null)";

   db1.OpenDatabase();
   db1.ExecuteQuery(sql);

   sql = "create table conta " + 
   "(cod_conta int primary key," + 
   "cod_cliente int not null," + 
   "cod_agencia int not null," + 
   "cod_tipo_conta int not null," + 
   "cod_do_banco int not null," + 
   "numero_conta int not null," + 
   "saldo int not null," + 
   "constraint fk_cod_cliente foreign key (cod_cliente) references cliente (cod_cliente)," + 
   "constraint fk_cod_agencia foreign key (cod_agencia) references agencia (cod_agencia)," + 
   "constraint fk_cod_do_banco foreign key (cod_do_banco) references codigo_banco (id_cod_banco)," + 
   "constraint fk_cod_tipo_conta foreign key (cod_tipo_conta) references tipo_conta (cod_tipo_conta) )"; 

   db1.OpenDatabase();
   db1.ExecuteQuery(sql);

   sql = "create table outros_bancos " + 
   "(cod_conta_outro_banco int primary key," + 
   "cod_tipo_conta int not null," + 
   "cod_agencia int not null," + 
   "cod_do_banco int not null," + 
   "numero_conta int not null," + 
   "constraint fk_cod_outro_banco foreign key (cod_do_banco) references codigo_banco (id_cod_banco)," + 
   "constraint fk_cod_conta_outro_banco foreign key (cod_tipo_conta) references tipo_conta (cod_tipo_conta)," + "constraint fk_cod_agencia_outro_banco foreign key (cod_agencia) references agencia (cod_agencia))";
 
   db1.OpenDatabase();
   db1.ExecuteQuery(sql);

   sql = "create table operacoes_bancarias " + 
   "(cod_operacoes int primary key," + 
   "nome_da_transacao varchar(25) not null)";

   db1.OpenDatabase();
   db1.ExecuteQuery(sql);
  
   sql = "create table transacoes " + 
   "(cod_transacoes int primary key," + 
   "cod_operacoes int not null," + 
   "cod_conta_nosso_banco int not null," + 
   "cod_do_nosso_banco int not null," + 
   "cod_do_outro_banco int not null," + 
   "valor int not null," + 
   "constraint fk_cod_do_nosso_banco foreign key (cod_do_nosso_banco) references codigo_banco (id_cod_banco)," + 
   "constraint fk_cod_do_outro_banco foreign key (cod_do_outro_banco) references codigo_banco (id_cod_banco)," + 
   "constraint fk_cod_operacoes foreign key (cod_operacoes) references operacoes_bancarias (cod_operacoes)," + 
   "constraint fk_cod_conta_nosso_banco foreign key (cod_conta_nosso_banco) references conta (cod_conta)," + 
   "constraint fk_cod_conta_outro_banco_transacoes foreign key (cod_do_outro_banco) references outros_bancos (cod_conta_outro_banco) )";



   sql = "insert into agencia" + "(cod_agencia) values ('1'), " +
   "(num_agencia) values ('2176')," +
   "(nome_agencia) values ('Santander')";
sql = "insert into codigo_banco " + "(id_cod_banco) values ('1')," + 
   "(cod_do_banco) values ('341')," + "(nome_do_banco) values ('Itau Unibanco')";

   sql = "insert into codigo_banco" + "(id_cod_banco) values ('2')," + 
   "(cod_do_banco) values ('033')," + 
   "(nome_do_banco) values ('Santander')"; 

   sql = "insert into codigo_banco" + "(id_cod_banco) values ('3')," + 
   "(cod_do_banco) values ('237')," + 
   "(nome_do_banco) values ('Bradesco')";
   
   sql = "insert into codigo_banco" + "(id_cod_banco) values ('4')," + 
   "(cod_do_banco) values ('104')," + 
   "(nome_do_banco) values ('Caixa Econômica Federal')";
   
   sql = "insert into codigo_banco" + "(id_cod_banco) values ('5')," + 
   "(cod_do_banco) values ('011')," + 
   "(nome_do_banco) values ('Banco do Brasil')"; 
   
 db1.ExecuteQuery(sql);
  db1.CloseDatabase(); 

   sql = "insert into tipo_conta" + "(cod_tipo_conta) values ('1')," + 
   "(conta) values ('Corrente')";

   sql = "insert into tipo_conta" + "(cod_tipo_conta) values ('2')," + 
   "(conta) values ('Poupança')";

   sql = "insert into tipo_conta" + "(cod_tipo_conta) values ('1')," + 
   "(conta) values ('Salario')";

  db1.ExecuteQuery(sql);
  db1.CloseDatabase();

   sql = "insert into cliente" + "(cod_cliente) values ('1')," + 
   "(primeiro_nome) values ('Gabriel')," + 
   "(sobrenome) values ('Pereira'), " + 
   "(cep) values ('08432-070')," + 
   "(endereco) values ('Rua das Laranjeiras, 135')," + 
   "(cpf_cnpj) values ('783-234-908-00')," + 
   "(telefone) values ('9087-7651')";

   sql = "insert into cliente" + "(cod_cliente) values ('2')," + 
   "(primeiro_nome) values ('Vitor')," + 
   "(sobrenome) values ('Augusto'), " + 
   "(cep) values ('08553-908')," + 
   "(endereco) values ('Rua das Orquideas, 234')," + 
   "(cpf_cnpj) values ('987-098-541-17')," + 
   "(telefone) values ('9652-8761')";

   sql = "insert into cliente" + "(cod_cliente) values ('3')," + 
   "(primeiro_nome) values ('Nicolas')," + 
   "(sobrenome) values ('Messias'), " + 
   "(cep) values ('08765-080')," + 
   "(endereco) values ('Rua das Bananeiras, 800')," + 
   "(cpf_cnpj) values ('180-900-535-18')," + 
   "(telefone) values ('9012-5518')";

db1.ExecuteQuery(sql);
  db1.CloseDatabase();

   sql = "insert into conta" + "(cod_conta) values ('1')," + 
   "(cod_cliente) values ('1')," + 
   "(cod_agencia) values ('1')," +
   "(cod_tipo_conta) values ('1')," + 
   "(cod_do_banco) values ('341')," +
   "(numero_conta) values ('85672-0')," + 
   "(saldo) values ('200.00')";

   sql = "insert into conta" + "(cod_conta) values ('2')," + 
   "(cod_cliente) values ('2')," + 
   "(cod_agencia) values ('2')," +
   "(cod_tipo_conta) values ('2')," + 
   "(cod_do_banco) values ('033')," +
   "(numero_conta) values ('1234-5')," + 
   "(saldo) values ('500.00')";

   sql = "insert into conta" + "(cod_conta) values ('3')," + 
   "(cod_cliente) values ('3')," + 
   "(cod_agencia) values ('1')," +
   "(cod_tipo_conta) values ('3')," + 
   "(cod_do_banco) values ('237')," +
   "(numero_conta) values ('7654-1')," + 
   "(saldo) values ('1500.00')";

  db1.ExecuteQuery(sql);
  db1.CloseDatabase();

  sql = "insert into operacoes_bancarias" + "(cod_operacoes) values ('1')," + 
  "(nome_da_transacao) values ('Transferência de Dinheiro')";

  sql = "insert into operacoes_bancarias" + "(cod_operacoes) values ('2')," + 
  "(nome_da_transacao) values ('Operações de Depósito')";
  
  sql = "insert into operacoes_bancarias" + "(cod_operacoes) values ('3')," + 
    "(nome_da_transacao) values ('Pix')";
    
    sql = "insert into operacoes_bancarias" + "(cod_operacoes) values ('4')," + 
  "(nome_da_transacao) values ('Operacões de Saque')"; 

  db1.ExecuteQuery(sql);
  db1.CloseDatabase();
 

  sql = "insert into transacoes" + "(cod_transacoes) values ('1')," + 
  "(cod_operacoes) values ('1')," + 
  "(cod_conta_nosso_banco) values ('1')," + 
  "(cod_do_nosso_banco) values ('1')," + 
  "(cod_do_outro_banco) values ('1')," +
  "(cod_conta_outro_banco) values ('1')," +
  "(valor) values ('200')"; 

  sql = "insert into transacoes" + "(cod_transacoes) values ('2')," + 
  "(cod_operacoes) values ('2')," + 
  "(cod_conta_nosso_banco) values ('2')," + 
  "(cod_do_nosso_banco) values ('2')," + 
  "(cod_do_outro_banco) values ('2')," +
  "(cod_conta_outro_banco) values ('2')," +
  "(valor) values ('500')";
  
  sql = "insert into transacoes" + "(cod_transacoes) values ('3')," + 
  "(cod_operacoes) values ('3')," + 
  "(cod_conta_nosso_banco) values ('3')," + 
  "(cod_do_nosso_banco) values ('3')," + 
  "(cod_do_outro_banco) values ('3')," +
  "(cod_conta_outro_banco) values ('3')," +
  "(valor) values ('1500')";
  
  
  db1.ExecuteQuery(sql);
  db1.CloseDatabase();

  
   

   
  }

  }

