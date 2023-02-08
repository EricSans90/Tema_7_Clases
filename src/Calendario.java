public class Calendario {
    private int año;
    private int mes;
    private int dia;

    Calendario(int año, int mes, int dia){
        if (mes<1 || mes>12){
            System.out.println("Fecha equivocada: el mes debe estar entre 1 y 12");
        } else {
            if (dia<1 || dia > diasDelMes(año,mes)){
                System.out.println("Fecha equivocada: el mes debe estar entre 1 y 12");
            } else {
                this.año=año;
                this.mes=mes;
                this.dia=dia;
            }
        }
    }
    private int diasDelMes(int año, int mes) {
        switch (mes){
            case 2:
                if (esBisiesto(año)){
                    return 29;
                } else {
                    return 28;
                }
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }
    private boolean esBisiesto(int año) {
        return (año % 400 == 0 || (año % 4 == 0 && año % 100 != 0));
    }

    public void incrementarDia(){
        int diasEnMes = diasDelMes(año,mes);
        if(dia == diasEnMes){
            dia = 1;
            mes += 1;
            if (mes>12){
                mes =1;
                año +=1;
            }
        }else {
            dia +=1;
        }
    }

}
