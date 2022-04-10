package co.edu.udea.tecnicasp.notesystem.dao.impl;

import co.edu.udea.tecnicasp.notesystem.dao.CursoDao;
import co.edu.udea.tecnicasp.notesystem.dao.exceptions.CursoRepetidoException;
import co.edu.udea.tecnicasp.notesystem.model.Curso;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOFile implements CursoDao {

    private File cursoBD;

    public CursoDAOFile() {
        cursoBD = new File("Cursos");
        if (!cursoBD.exists()) {
            try {
                cursoBD.createNewFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }


    @Override
    public void registrarCurso(Curso curso) throws CursoRepetidoException
    {

        if(!consultarCursoPorCod(curso.getCodigo()).equals(consultarCursoPorCod(curso.getCodigo())))
        {
            throw new CursoRepetidoException();
        }

        String cursoString = String.format("%d;%s;%s\n", curso.getCodigo(),curso.getNombre(), curso.getCreditos());
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(cursoBD, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(cursoString);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Curso> ListarCursos() {
        List<Curso> resultado = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(cursoBD);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String registro;
            while ((registro = bufferedReader.readLine()) != null) {
                Curso curso = parseCursoFromString(registro);
                resultado.add(curso);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }


    private Curso parseCursoFromString(String registro) {
        String[] partes = registro.split(";");
        return new Curso(Integer.parseInt(partes[0]), partes[1], Integer.parseInt(partes[2]));
    }

    @Override
    public Curso consultarCursoPorCod(Integer cod) {
        try {
            FileReader fileReader = new FileReader(cursoBD);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String registro;
            while ((registro = bufferedReader.readLine()) != null) {
                Curso curso = parseCursoFromString(registro);
                if (curso.getCodigo().equals(cod)) {
                    return curso;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;//posible error
    }
}
