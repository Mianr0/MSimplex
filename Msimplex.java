/**
 * @(#)Msimplex.java
 *
 *
 * @author 
 * @version 1.00 2010/5/27
 */

import javax.swing.*;

public class Msimplex{
	int x= Integer.parseInt(JOptionPane.showInputDialog("Digite un numero de filas"));
	int y= Integer.parseInt(JOptionPane.showInputDialog("Digite un numero de columnas"));
	double[][] A = new double [x][y];
	int aux=0;
    int aux1=1;
	int a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p;
	
    public Msimplex(){
    }
    
    void Insertar(){
    	int z=0;
    	for(a=0; a<=x-1; a++) {
	  		for (b=0; b<=y-1; b++) {
	  			if(b==0){
	  				z=z+1;
	  				System.out.println("Ingrese un numero");
	  				A[a][b]= Double.parseDouble(JOptionPane.showInputDialog("Digite un numero de la fila "+z));
	  			}
	  			else{
	  				System.out.println("Ingrese un numero");
	  				A[a][b]= Double.parseDouble(JOptionPane.showInputDialog("Digite un numero"));
	  			}
	  		}
	  	}
    }
    
    void Solucionar(){
    	for (c=0; c<=y-1; c++){
    		if(A[0][aux]<=A[0][c]){
    			aux=aux;
    		}
    		else{
    			aux=c;
    		}
      	}
      	if(A[0][aux]<0){
      		for (d=1; d<=x-1; d++){
      			if(A[aux1][y-1]/A[aux1][aux]<=A[d][y-1]/A[d][aux]){
      				aux1=aux1;
      			}
      			else{
      				aux1=d;
      			}
      		}
      	}
      	if(A[aux1][aux]==1){
      		for(e=0; e<=x-1; e++){
      			if(e!=aux1){
      				for(f=-100; f<=100; f++){
      					if((A[e][aux]+(A[aux1][aux]*f))==0){
      						for(g=0; g<=y-1; g++){
      							A[e][g]=A[e][g]+(A[aux1][g]*f);
      						}
      					}
      					else{
      						for(h=-100; h<=100; h++){
      							if((A[e][aux]-(A[aux1][aux]*h))==0){
      								for(i=0; i<=y-1; i++){
      									A[e][i]=A[e][i]-(A[aux1][i]*h);
      								}
      							}
      							else{
      								for(j=-100; j<=100; j++){
      									if((A[e][aux]+(A[aux1][aux]/j))==0){
      										for(k=0; k<=y-1; k++){
      											A[e][k]=A[e][k]+(A[aux1][k]/j);
      										}
      									}
      									else{
      										for(l=-100; l<=100; l++){
      											if((A[e][aux]-(A[aux1][aux]/l))==0){
      												for(m=0; m<=y-1; m++){
      													A[e][m]=A[e][m]-(A[aux1][m]/l);
      												}
      											}
      										}
      									}
      								}
      							}
      						}
      					}
      				}
      			}
      		}
      	}
      	else{
      		for (k=-100; k<=100; k++){
      			if(A[aux1][aux]*k==1){
      				for (l=0; l<=y-1; l++){
      					A[aux1][l]=A[aux1][l]*k;
      				}
      			}
      			else{
      				for (m=-100; m<=100; m++){
      					if(A[aux1][aux]/m==1){
      						for (n=0; n<=y-1; n++){
      							A[aux1][n]=A[aux1][n]/m;
      						}
      					}
      				}
      			}
      		}
      	}
    }
    
    void Mostrar(){
    	String Mensaje="";
	  	for(o=0; o<=x-1; o++) {
	  		for(int p=0; p<=y-1; p++){
	  			if(p==0){
	  				Mensaje+="\n"+A[o][p]+" | ";
	  			}
	  			else{
	  				Mensaje+=A[o][p]+" | ";
	  			}
	  		} 
	  	}
	  	JOptionPane.showMessageDialog(null,Mensaje);
	}
	
    public static void main(String args[]){
    	Msimplex A1=new Msimplex();
    	int opcion;
    	do
    	{
    		opcion= Integer.parseInt(JOptionPane.showInputDialog("                   Nuevo\n"+
    	 	"------------------------------------\n"+
    	 	"1. Insertar\n"+
    	 	"2. Mostrar\n"+
    	 	"3. Solucionar\n"+
    	 	"4. Salir\n"));
    	 	switch (opcion)
    	 	{
    	 		case 1: A1.Insertar();
    	 	    	   break;
	        	case 2: A1.Mostrar();
	        		   break;
	        	case 3: A1.Solucionar();
	        		   break;
	        	case 4:
	        		   break;
	        	default: JOptionPane.showMessageDialog(null,"Numero no autorizado");
    	 	} 		
    	}while (opcion!=4);	  
    }
}