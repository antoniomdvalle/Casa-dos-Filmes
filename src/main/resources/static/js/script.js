$(document).ready(function(){

/*
    const filmeId = $("#filmeId").val();

    if (filmeId){
        carregarAnalisesDoFilme(filmeId);
    }
*/

// -------- MÉTODOS DOS FILMES --------
// GET GERALZÃO
function carregarFilmes(){
    $.ajax({
        url: "http://localhost:8080/filme/listar",
        method: "GET",
        success: function (data) {
            console.log("Filmes recebidos: ", data);
            console.log("Quantidade de filmes recebidos: ", data.length);
            // limpar registros
            $("#tabelaFilmes tbody").empty();
            // adiciona cada filme a tabela
            for (let i = 0; i < data.length; i++){
                let filme = data[i];
                let id = $("<td>")
                    .text(filme.id);
                let titulo = $("<td>")
                    .text(filme.titulo);
                let sinopse = $("<td>")
                    .text(filme.sinopse);
                let genero = $("<td>")
                    .text(filme.genero);
                let anoLancamento = $("<td>")
                    .text(filme.anoLancamento);
                let botaoAtualizar = $("<button type='button' class='btn btn-primary'>Atualizar</button>")
                    .click(function(){
                        let linhaTr = $(this).closest("tr");
                        let filmeId = linhaTr.attr("data-id");
                        window.location.href = "/atualizar/" + filmeId;
                    });
                let atualizar = $("<td>")
                    .append(botaoAtualizar);
                let botaoDeletar = $("<button type='button' class='btn btn-danger'>Excluir</button>")
                    .click(function(){
                        if(confirm('Tem certeza?')){
                            deletarFilme($(this).closest("tr").attr("data-id"));
                        }
                    });
                let deletar = $("<td>")
                    .append(botaoDeletar);

                let tr = $('<tr>')
                    .attr('data-id', filme.id)
                    .data("filme", filme)
                    .append(id)
                    .append(titulo)
                    .append(sinopse)
                    .append(genero)
                    .append(anoLancamento)
                    .append(atualizar)
                    .append(deletar)
                $("#tabelaFilmes tbody").append(tr);
            }

        },
        error: function (){
            alert("Não foi possível cadastrar o filme.");
        }
    })
};
// SUBMIT FORM CADASTRO
$("#formCadastrarFilme").submit(function (event) {
    event.preventDefault(); // usado pra prevenir o reload da página

    const filme = {
        titulo: $("#titulo").val(),
        sinopse: $("#sinopse").val(),
        genero: $("#genero").val(),
        anoLancamento: parseInt($("#anoLancamento").val())
    };

    $.ajax({
        url: 'http://localhost:8080/filme/cadastro',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(filme),

        success: function(response){
            window.location.href = '/'; // redireciona pra lista no caso
            console.log(response);
        },

        error: function(error){
            alert('Erro no cadastro do filme.');
            console.log(error);
        }
    });

});

function carregarFilmeParaAtualizar(id){
$.ajax({
    url: "http://localhost:8080/filme/pesquisar/" + id,
    method: "GET",
    success: function (filme){
        $("#titulo").val(filme.titulo);
        $("#sinopse").val(filme.sinopse);
        $("#genero").val(filme.genero);
        $("#anoLancamento").val(filme.anoLancamento);
    },
    error: function (xhr){
        console.error("Erro ao buscar filme: ", xhr);
        alert("Não foi possível carregar os dados do filme.");
    }
})
}

function atualizarFilme(id, filme){
    $.ajax({
        url: 'http://localhost:8080/filme/atualizar/' + id,
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(filme),
        success: function (data){
            window.location.href = "/";
        },
        error: function(xhr){
            console.error("Erro ao atualizar o filme: ", xhr)
            alert("Não foi possível atualizar o filme.");
        }
    })
};
// checagem para ver se estou na página de atualizar com objeto hidden
const filmeId = $("#filmeId").val();

if($("#formAtualizar").length && filmeId){
    carregarFilmeParaAtualizar(filmeId);
}

$("#formAtualizar").submit(function (event){
    event.preventDefault();
    const id = $("#filmeId").val();

    const filme = {
        titulo: $("#titulo").val(),
        sinopse: $("#sinopse").val(),
        genero: $("#genero").val(),
        anoLancamento: parseInt($("#anoLancamento").val(), 10)
    };
    atualizarFilme(id, filme);
})


function deletarFilme(id){
$.ajax({
    url: "http://localhost:8080/filme/deletar/" + id,
    method: "DELETE",
    success: function(data){
        carregarFilmes();
    },
    error: function (xhr){
        console.error("Erro encontrado ao tentar excluir filme: ", xhr);
        alert("Não foi possível excluir os dados.")
    }
})
};


// -------- MÉTODOS DAS ANÁLISES --------

function carregarAnalisesDoFilme(filmeId){
    $.ajax({
        url: "http://localhost:8080/analise/pesquisar/filme/" + filmeId,
        method: "GET",
        success: function (data){
            console.log("Quantidade de análises para este filme: ", data.length);
            $("#tabelaAnalises tbody").empty();

            for(let i = 0; i < data.length; i++){
                let item = data[i];
                let id = $("<td>")
                    .text(item.id);
                let nota = $("<td>")
                    .text(item.nota);
                let textoAnalise = $("<td>")
                    .text(item.analise);

                let botaoAtualizar = $("<button type='button' class='btn btn-primary'>Atualizar</button>")
                    .click(function(){
                        let analiseId = $(this).closest("tr").attr("data-id");
                        window.location.href = "/atualizarAnalise/" + analiseId + "/" + filmeId;
                    });
                let atualizar = $("<td>")
                    .append(botaoAtualizar);

                let botaoDeletar = $("<button type='button' class='btn btn-danger'>Excluir</button>")
                    .click(function(){
                        if(confirm('Tem certeza?')){
                            deletarAnalise($(this).closest("tr").attr("data-id"));
                        }
                    });
                let deletar = $("<td>")
                    .append(botaoDeletar);
                    
                let tr = $("<tr>")
                    .attr("data-id", item.id)
                    .data("analise", item)
                    .append(id)
                    .append(nota)
                    .append(textoAnalise)
                    .append(atualizar)
                    .append(deletar)
                $("#tabelaAnalises tbody").append(tr);
            }
        },
        error: function (xhr){
            console.error("Erro encontrado ao procurar análises: ", xhr);
        }
    })
};

function carregarAnaliseParaAtualizar(id){
    $.ajax({
        url: "http://localhost:8080/analise/pesquisar/" + id,
        method: "GET",
        success: function (item){
            $("#analise").val(item.analise);
            $("#nota").val(item.nota)
        },
        error: function (xhr){
            console.error("Erro encontrado: ", xhr);
            alert("Não foi possível encontrar a análise de id: ", id);
        }
    })
}

const analiseId = $("#analiseId").val();

if(analiseId){
    carregarAnaliseParaAtualizar(analiseId);
}

$("#formAnalise").submit(function (event){
    event.preventDefault();
    
    const filmeId = $("#filmeId").val();
    const analiseId = $("#analiseId").val();
    
    const item = {
        analise: $("#analise").val(),
        nota: parseFloat($("#nota").val())
    };

    const editando = Boolean(analiseId);

    $.ajax({
        url: editando
        ? "http://localhost:8080/analise/atualizar/" + analiseId
        : "http://localhost:8080/analise/cadastro/filme/" + filmeId,
        method: editando ? "PUT" : "POST",
        contentType: "application/json",
        data: JSON.stringify(item),
        success: function (){
            window.location.href = "/atualizar/" + filmeId;
        },
        error: function (xhr){
            console.error("Erro encontrado: ", xhr);
            console.error("Resposta do servidor: ", xhr.responseText);
            alert("Não foi possível cadastrar a análise.");
        }
    })
})


function deletarAnalise(id){
    const filmeId = $("#filmeId").val();
    $.ajax({
        url: "http://localhost:8080/analise/deletar/" + id,
        method: "DELETE",
        success:function (){
            carregarAnalisesDoFilme(filmeId);
        },
        error: function (xhr){
            console.error("Erro encontrado: ", xhr);
            alert("Não foi possível excluir.");
        }
    })
};

if($("#tabelaFilmes").length){
    carregarFilmes();
}

if($("#tabelaAnalises").length && filmeId){
    carregarAnalisesDoFilme(filmeId);
}

});