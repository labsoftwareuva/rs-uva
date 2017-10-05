# RS-UVA

O RS-UVA tem como objetivo, agilizar as tarefas de entrevistas e marketing de vagas de emprego. Abaixo, seguirão algumas instruções para equipes de implementação e testes.

### Pré-requisitos

Abaixo, tudo que você precisa para rodar a aplicação.
Acesse os links listados abaixo e faça o download dos arquivos de instalação.

+ [Node](https://nodejs.org/)
+ [Git](https://git-scm.com/downloads)
+ [Eclipse IDE](https://www.eclipse.org/downloads/)

#### Agora, abra seu terminal e execute os seguintes comandos:

Para instalar o gerenciador de pacos do Node, o **NPM**:
```
npm install npm@latest -g
```
Para instalar o **Bower**, gerenciador de dependencias do projeto:
```
npm install -g bower
```

### Passo a passo

Estas instruções irão levá-lo a uma cópia do projeto em funcionamento em sua máquina local para fins de desenvolvimento e teste.

---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-01.jpg)
> Abra seu Eclipse. Na tela de boas vindas, selecione a opção _Checkout projects from Git_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-02.jpg)
> Clique na opção _CloneURI_ e, em seguida, no botão _Next_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-03.jpg)
> 1. Acesse o repositório do projeto
> 2. Clique no botão _Clone or Download_
> 3. Clique no botão da _prancheta_ para colar a URI
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-04.jpg)
> Retorne para o Eclipse e:
> 1. Cole a URI no campo _URI_ (Todos os outros campos serão preenchidos automaticamente)
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-05.jpg)
> 2. Clique no botão _Next_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-06.jpg)
> 1. Selecione os branches que deseja baixar(recomendo selecionar toda a lista, caso existam vários) e clique no botão _Next_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-07.jpg)
> 1. Escolha um diretório em sua máquina, para armazenar os arquivos do projeto
> 2. Clique no botão _Next_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-08.jpg)
> Aguarde até que o projeto seja clonado
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-09.jpg)
> 1. Selecione a opção _Import existing Eclipse projects_
> 2. Clique no botão _Next_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-10.jpg)
> 1. Clique no botão _Finish_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-11.jpg)
> Aguarde até que o processo seja finalizado
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-12.jpg)
> Caso alguma biblioteca Java, que o projeto dependa, esteja faltando em sua IDE, a janela de Markeplace aparecerá
> 1. Clique no botão _Show Solutions_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-13.jpg)
> Instale a primeira biblioteca clicando sobre o botão _Install_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-14.jpg)
> Clique sobre o botão _Confirm_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-15.jpg)
> 1. Aceite os termos selecionando a opção _I accept the terms of the license agreement_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-16.jpg)
> Clique no botão _Finish_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-17.jpg)
> Uma barra de status aparecerá no canto inferior direito da tela. Aguarde até que a instalação encerre
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-18.jpg)
> Clique na opção **_No_** para instalar as demais dependências, antes de restartar a IDE
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-19.jpg)
> 1. Clique com o botão direito na pasta raiz do projeto _rsuva_
> 2. Selecione a opção _Maven > Update Project..._
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-20.jpg)
> 1. Clique no botão _Ok_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-21.jpg)
> Novamente, a janela de Marketplace aparecerá lembrando-nos que ainda temos dependencias ausentes no projeto
> Vamos repetir o processo de instalação clicando no botão _Show Solutions_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-22.jpg)
> Clique no botão _Install_ e repita o processo de instalação
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-23.jpg)
> Ao final da instalação, caso não exista mais nenhuma dependencia a ser instalada, clique no botão _Restart Now_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-24.jpg)
> Ao reiniciar a IDE
> 1. Selecione a pasta _View_
> 2. Clique no menu dropdown da opção _Run_
> 3. Selecione a opção _Run as > Bower Update_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-25.jpg)
> Acompanhe a barra de status no canto inferior direito e aguarde o término da atualização
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-26.jpg)
> Atualize o projeto novamente
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-27.jpg)
> Clique no botão _Ok_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-28.jpg)
> 1. Clique com o botão direito na pasta raiz
> 2. Clique no menu dropdown da opção _Run_
> 3. Selecione a opção _Run as > Run on Server_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-31.jpg)
> 1. Clique na pasta _Apache_
> 2. Role o scroll até chegar na opção _Tomcat v8.0 Server_
> 3. Clique no botão _Next_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-33.jpg)
> 1. Escolha um diretório em sua máquina para instalação do _Tomcat_
> 2. Clique no botão _Download and Install..._
> 3. Clique no botão _Finish_
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-34.jpg)
> 1. Copie o link _http://localhost:8080/rsuva_ e cole em seu navegador para ver a aplicação rodando em sua máquina local
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-35.jpg)
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-36.jpg)
---
![alt text](https://github.com/labsoftwareuva/rs-uva/raw/master/view/img/docs/print-37.jpg)
---