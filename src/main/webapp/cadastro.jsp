<%@page import="db.User"%>
<%@ page pageEncoding="UTF-8" %>
<%@page import="DbListener"%>
                <!--FORMULÁRIO PARA CADASTRO -->
                <div id="cadastro">
                    <form method="post" action="">
                        <h1>Cadastro</h1>
                        <p>
                            <label for="nome-cad">Nome</label>
                            <input id="nome-cad" name="nome-cad" required="required" type="text">
                        </p>
                        <p>
                            <label for="senha-cad">Senha</label>
                            <input id="senha-cad" name="senha-cad" required="required" type="password">
                        </p>
                        <p>
                            <input type="submit" value="Cadastrar"/>
                        </p>
                        
                        <p class="link">
                            Já tem conta?
                            <a href="<%=request.getContextPath()%>/index.jsp">Ir para login</a>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>