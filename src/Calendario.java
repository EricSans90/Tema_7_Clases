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

    public void incrementarMes(){
        if(mes == 12){
            mes =1;
            año +=1;
            }else{
            mes +=1;
        }
        // Es posible que la nueva fecha no sea válida, por ejemplo al pasar del 30 de enero al "30 de febrero",
        // lo ajustaremos dejando el último día del mes, aunque también podríamos imprimir un error
        int diasEnMes = diasDelMes(año,mes);
        if (dia > diasEnMes){
            dia = diasEnMes;
        }
    }

    public void incrementarAño(int cantidad){
        año += cantidad;
        // Es posible que la nueva fecha no sea válida, por ejemplo al pasar del 29 de febrero del 2024
        // al "29 de febrero" de otro año que no fuese bisiesto. Lo ajustaremos dejando el último día del mes,
        // aunque también podríamos imprimir un error
        int diasEnMes = diasDelMes(año, mes);
        if (dia > diasEnMes) {
            dia = diasEnMes;
        }
    }

    public void mostrar(){
        System.out.println("La fecha es:");
        System.out.println(dia+"/"+mes+"/"+año);
    }

    public boolean iguales(Calendario otraFecha){
        if(año== otraFecha.getAño() && mes== otraFecha.getMes() && dia== otraFecha.getDia()){
            return true;
        } else {
            return false;
        }
    }

    public int getAño() {
        return año;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }
}
