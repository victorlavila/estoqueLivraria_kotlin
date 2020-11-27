class Livro (val codigo : Int,
             var titulo : String,
             var autor : String,
             var anoDeLancamento : Int,
             var codISBN : Int,
             var qtdEstoque : Int,
             var preco : Double) : Sistema {

    var listaDeLivros = mutableListOf<Livro>()

    override fun cadastrarLivros(livro: Livro) {
        listaDeLivros.add(livro)
        println("Cadastro efetuado com sucesso!")
    }

    override fun consultarLivros(livro : Livro) {
        for(livro in listaDeLivros){
            print("Digite o código do livro: ")
            var codDigitado = readLine()?.toInt()
            if(codDigitado == livro.codigo )
                println("Livro: $titulo \nAutor: $autor \nAno de lançamento: $anoDeLancamento \nCód. ISBN: $codISBN \nEstoque: $qtdEstoque \nPreço: R$$preco reais")
            else println("Livro não encontrado")
        }
    }

    override fun efetuarVenda(livro: Livro) {
        for(livro in listaDeLivros){
            print("Código do livro vendido: ")
            var codDigitado = readLine()?.toInt()
            if(codDigitado == livro.codigo ){
                println("Livro: $titulo, autor: $autor")
                print("Quantos livros serão vendidos?")
                var livrosVendidos = readLine()?.toInt()
                if(livro.qtdEstoque > 0){
                    if (livrosVendidos != null) {
                        livro.qtdEstoque -= livrosVendidos
                    }
                    println("Livro: $titulo \nEstoque atual: $qtdEstoque")
                } else{
                    println("Estoque esgotado")
                }
            } else {
                println("Livro não encontrado")
            }
        }
    }
}