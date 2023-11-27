$(document).ready(function () {
    $('.menu-list > a').click(function (e) {
        e.preventDefault();
        $(this).parent().toggleClass('active');
    });

    $("#addClientes").click(function () {
        
        if ($(this).parent().hasClass('active')) {
            
        }
    });
});

    //$("#ordemServico").show();

    
    /*$("#addClientes").click(function (e) {
        e.preventDefault();
      
        $("#formularioAddClientes").show();        
         $("#formularioAddOS").hide();
         $("#listarOS").hide();
         $("#excluirOS").hide();
         $("#ordemServico").hide();
    });
    $("#addOS").click(function (e) {
        e.preventDefault();
       
        $("#formularioAddClientes").hide();        
         $("#formularioAddOS").show();
         $("#pesquisarOS").hide();
         $("#excluirOS").hide();
         $("#editarOS").hide();
         $("#ordemServico").hide();
    });
    
    $("#inicio").click(function (e) {
        e.preventDefault();
       
        $("#formularioAddClientes").hide();
         $("#formularioAddOS").hide();
         $("#pesquisarOS").hide();
         $("#excluirOS").hide();
         $("#editarOS").hide();
         $("#ordemServico").show();
    });
    $("#localizarOS").click(function (e) {
        e.preventDefault();
       
        $("#formularioAddClientes").hide();
         $("#formularioAddOS").hide();
         $("#ordemServico").hide();
         $("#excluirOS").hide();
         $("#editarOS").hide();
         $("#pesquisarOS").show();
    });
    $("#apagarOS").click(function (e) {
        e.preventDefault();
       
        $("#formularioAddClientes").hide();
         $("#formularioAddOS").hide();
         $("#ordemServico").hide();
         $("#pesquisarOS").hide();
         $("#editarOS").hide();
         $("#excluirOS").show();
    });
    $("#alterarOS").click(function (e) {
        e.preventDefault();
       
        $("#formularioAddClientes").hide();
         $("#formularioAddOS").hide();
         $("#ordemServico").hide();
         $("#pesquisarOS").hide();
         $("#excluirOS").hide();
         $("#editarOS").show();
    });

});

function validarCadastroCliente() {
    var nome = document.getElementById('Nome').value;
    var cep = document.getElementById('cpf').value;

    if (nome === '' && cep === '') {
        alert('Por favor, preencha os campos Nome e CPF.');
    } else if (nome === '') {
        alert('Por favor, preencha o campo Nome.');
    } else if (cep === '') {
        alert('Por favor, preencha o campo CEP.');
    } else {
        alert('Cadastro feito com sucesso');
    }
}

function validarCadastroOS() {
    var marca = document.getElementById('marca').value;
    var tipo = document.getElementById('tipo').value;
    var acessorios = document.getElementById('acessorios').value;
    var def_recl = document.getElementById('def_recl').value;

    if (marca === '' && tipo === '') {
        alert('Por favor, preencha os campos os dados obrigatórios.');
    } else if (marca === '') {
        alert('Por favor, preencha o campo Marca.');
    } else if (tipo === '') {
        alert('Por favor, preencha o campo Tipo.');
    } else if ( def_recl=== '') {
        alert('Por favor, preencha o campo Defeito/ reclamação.');
    } else if (acessorios === '') {
        alert('Por favor, preencha o campo Acessórios.');
    } else {
        alert('Cadastro feito com sucesso');
    }
}

function validarExcluirOS() {
    var excluir = document.getElementById('ExcluirOS').value;

    if (excluir === '' ) {
        alert('Por favor, preencha o numero da Ordem de Serviço.');
    
    } else {
        alert('Exclusão feita com sucesso');
    }
}

function validarPesquisarOS() {
    var pesquisar = document.getElementById('PesquisarOS').value;
    

    if (pesquisar === '' ) {
        alert('Por favor, preencha o numero da Ordem de Serviço.');
    
    } else {
        
    }
}   

function validarEditarOS() {
    var editar = document.getElementById('EditarOS').value;
    

    if (editar === '' ) {
        alert('Por favor, preencha o numero da Ordem de Serviço.');
    
    } else {
        alert('Edição feita com sucesso');
    }
}   
/*
*/
$('#pesquisarCliente').click(function () {
            var clienteNome = $('#clientePesquisa').val();

            // Fazer a requisição AJAX para pesquisar clientes
            $.ajax({
                type: "GET",
                url: "/pesquisarClientePorNome",
                data: {clienteNome: clienteNome},
                success: function (data) {
                    // Atualizar a área de resultados
                    $('#resultadosPesquisa').html(data);
                }
            });
        });

        // Lidar com o clique nos itens de cliente encontrados
        $(document).on('click', '.cliente-item', function () {
            var clienteId = $(this).attr('th:data-cliente-id');
            
            // Preencher o campo de cliente na OS com o ID do cliente selecionado
            $('#clienteId').val(clienteId);

            // Limpar a área de resultados
            $('#resultadosPesquisa').html('');
        });


// Lidar com o clique nos itens de cliente encontrados
$(document).on('click', '.cliente-item', function () {
    var clienteId = $(this).attr('th:data-cliente-id');
    
    // Preencher o campo de cliente na OS com o ID do cliente selecionado
    $('#clienteId').val(clienteId);

    // Limpar a área de resultados
    $('#osClientes').html('');
    
});


$('#pesquisarCliente').click(function () {
            var clienteNome = $('#clientePesquisa').val();

            $.ajax({
                type: "GET",
                url: "/listarOrdensPorCliente",
                data: {clienteNome: clienteNome},
                success: function (data) {
                    // Atualizar a área de resultados
                    $('#resultadoOSPesquisa').html(data);
                }
            });
        });

        // Lidar com o clique nos itens de cliente encontrados
        $(document).on('click', '.cliente-item', function () {
            var clienteId = $(this).attr('th:data-cliente-id');
            
            // Preencher o campo de cliente na OS com o ID do cliente selecionado
            $('#clienteId').val(clienteId);

            // Limpar a área de resultados
            $('#resultadoOSPesquisa').html('');
        });
