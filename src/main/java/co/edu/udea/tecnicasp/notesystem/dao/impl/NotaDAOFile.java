package co.edu.udea.tecnicasp.notesystem.dao.impl;

import co.edu.udea.tecnicasp.notesystem.dao.CursoDao;
import co.edu.udea.tecnicasp.notesystem.dao.NotaDao;
import co.edu.udea.tecnicasp.notesystem.model.Curso;
import co.edu.udea.tecnicasp.notesystem.model.Notas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NotaDAOFile implements NotaDao
{

    private File notasBD;

    private CursoDao cursoDao;

    public NotaDAOFile() {
        cursoDao = new CursoDAOFile();
        notasBD = new File("Notas");
        if (!notasBD.exists()) {
            try {
                notasBD.createNewFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    @Override
    public void registrarNota(Notas notas) {
        String notasString = String.format("%d;%s;%s\n", notas.getCurso().getCodigo(), notas.getNotas(),notas.getPorcentajes());
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(notasBD, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(notasString);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Notas> listarNotasPorCurso(Integer codigoCurso) {
        List<Notas> notas = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(notasBD);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String registro;
            while ((registro = bufferedReader.readLine()) != null) {
                Notas nota = parseNotasFromString(registro);
                if (nota.getCurso().getCodigo().equals(codigoCurso)) {
                    notas.add(nota);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return notas;
    }



    @Override
    public Notas consultarNotasPorCodigoCurso(Integer codCurso)
    {

        try {
            FileReader fileReader = new FileReader(notasBD);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String registro;
            while ((registro = bufferedReader.readLine()) != null) {
                Notas notas = parseNotasFromString(registro);
                if (notas.getCurso().getCodigo().equals(codCurso)) {
                    return notas;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Notas parseNotasFromString(String registro) {
        String[] partes = registro.split(";");
        Curso curso = this.cursoDao.consultarCursoPorCod(Integer.parseInt(partes[0]));
        Notas notas = new Notas(Double.parseDouble(partes[1]), Double.parseDouble(partes[2]));
        notas.setCurso(curso);
        return notas;
    }

}
