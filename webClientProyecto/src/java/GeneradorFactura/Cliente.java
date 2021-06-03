/*
 * Copyright (C) 2021 giova
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

/**
 *
 * @author Marvin Alonso Lemen Sanchez 090-17-99
 * @author GIOVANI DAVID MEZA POGGIO 5990-18-14676
 * @author Wendy Pricila Cifuentes Lutin 5990-18-4413
 * @author Byron Rosbin Antonio Orozco 9941-19-23685
 * @author Karina Aracely Sanchez Ixcot 9941-19-264
 */

package GeneradorFactura;


public class Cliente {
    
    public Cliente(){}

    private String Nombre;
    private String Nit;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNit() {
        return Nit;
    }

    public void setNit(String Nit) {
        this.Nit = Nit;
    }
    
    
    
}
