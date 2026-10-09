$(document).ready(function(){

/*
    const filmeId = $("#filmeId").val();

    if (filmeId){
        carregarAnalisesDoFilme(filmeId);
    }
*/

// -------- MÉTODOS DOS FILMES --------

function carregarFilmes(){};

$("#formCadastrarFilme").submit(function (event) {
    event.preventDefault(); // usado pra prevenir o reload da página

    const filme = {
        titulo: $("#titulo").val(),
        sinopse: $("#sinopse").val(),
        genero: $("#genero").val(),
        anoLancamento: parseInt($("#anoLancamento").val())
    };

    $.ajax({
        url: '/filme/cadastro',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(filme),

        success: function(response){
            alert('Filme cadastrado!');
            window.location.href = '/'; // redireciona pra lista no caso
            console.log(response);
        },

        error: function(error){
            alert('Erro no cadastro do filme.');
            console.log(error);
        }
    });

});

function atualizarFilme(){};

function deletarFilme(){};


// -------- MÉTODOS DAS ANÁLISES --------

function carregarAnalisesDoFilme(){};

function criarAnalise(){};

function atualizarAnalise(){};

function deletarAnalise(){};

carregarFilmes();
});