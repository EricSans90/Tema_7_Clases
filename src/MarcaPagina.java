public class MarcaPagina {
    private int numeroPaginas;
    private int ultimaPaginaLeida;

    public MarcaPagina(int numeroPaginas){
        if (numeroPaginas <=0){
            System.out.println("El número de páginas debe ser mayor a 0");
        } else {
            this.numeroPaginas = numeroPaginas;
            //al no declarar ultimaPaginaLeida se inicializa con valor por defecto 0 al ser numérico
        }
    }

    public void incrementarPagina (){
        if (this.ultimaPaginaLeida==this.numeroPaginas){
            System.out.println("Ya has terminado de leer el libro");
        } else {
            this.ultimaPaginaLeida +=1;
        }
    }

    public int getUltimaPaginaLeida() {
        return ultimaPaginaLeida;
    }

    public void empezarNuevaLectura(){
        this.ultimaPaginaLeida=0;
    }
}
