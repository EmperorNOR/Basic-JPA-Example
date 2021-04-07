package no.hvl.dat107;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class BrukerGrenseSnitt {
	
	
	
	public void grenseSnitt()
	{
		String[] operasjoner = {"Ansatt", "Avdeling", "Prosjekt", "Avslutt"}; 
		String s = (String) JOptionPane.showInputDialog(null, "Velg entitet", "Eniteter", JOptionPane.QUESTION_MESSAGE, null, operasjoner, operasjoner[0]);
		if(s.equals("Ansatt"))
		{
			AnsattDAO ansattDAO = new AnsattDAO();
			String[] ansattOperasjoner = {"Finn Ansatt", "Finn Initialer", "Oppdater", "Legg Til", "Avslutt"}; 
			String l = (String) JOptionPane.showInputDialog(null, "Velg entitet", "Eniteter", JOptionPane.QUESTION_MESSAGE, null, ansattOperasjoner, ansattOperasjoner[0]);
			if(l.equals("Finn Ansatt"))
			{
				int nr = Integer.parseInt(JOptionPane.showInputDialog("Skriv in ansattnr"));
				System.out.println(ansattDAO.finnAnsatt(nr));
			}
			else if(l.equals("Finn Initialer"))
			{
				String brukernavn = (JOptionPane.showInputDialog("Skriv in initialene til ansatt"));
				System.out.println(ansattDAO.finnInitialer(brukernavn));
			}
			else if(l.equals("Oppdater"))
			{
				Ansatt ansatt = new Ansatt();
				int id = Integer.parseInt(JOptionPane.showInputDialog("Skriv Id til den Ansatte"));
				ansatt.setStilling(JOptionPane.showInputDialog("Skriv in stillingstittel"));
				ansatt.setLonn(Integer.parseInt(JOptionPane.showInputDialog("Skriv in lonn")));
				ansattDAO.oppdaterAnsatt(id, ansatt.getStilling(), ansatt.getLonn());	
			}
			else if(l.equals("Legg Til"))
			{
				Ansatt ansatt = new Ansatt();
				ansatt.setBrukerNavn(JOptionPane.showInputDialog("Skriv in initialer"));
				ansatt.setForNavn(JOptionPane.showInputDialog("Skriv in fornavn"));
				ansatt.setEtterNavn(JOptionPane.showInputDialog("Skriv in etternavn"));
				LocalDate date = null;
				date.parse(JOptionPane.showInputDialog("Skriv in dato på formen: yyyy-mm-dd"));
				ansatt.setAnsettelsesDato(date);
				ansatt.setStilling(JOptionPane.showInputDialog("Skriv in stillingstittel"));
				ansatt.setLonn(Integer.parseInt(JOptionPane.showInputDialog("Skriv in lonn")));
				
				AvdelingDAO finnAvdeling = new AvdelingDAO();
				Avdeling avdelingen = finnAvdeling.finnAvdelingMedId(Integer.parseInt(JOptionPane.showInputDialog("Skriv in avdelings id")));
				
				ansattDAO.LeggTilAnsatt(ansatt.getBrukerNavn(), ansatt.getForNavn(), ansatt.getEtterNavn(),
						ansatt.getAnsettelsesDato(), ansatt.getStilling(), ansatt.getLonn(), avdelingen);
				
				System.out.println("Ansatt ble lagt til!");
			}
			else
			{
				System.exit(0);
			}
			
		}
		else if(s.equals("Avdeling"))
		{
			AvdelingDAO avdelingDAO = new AvdelingDAO();
			
			System.out.println(avdelingDAO.finnAvdelingMedId(Integer.parseInt(JOptionPane.showInputDialog("Skriv in avdelingsnummer"))));
		}
		else if(s.equals("Prosjekt"))
		{
			JOptionPane.showMessageDialog(null, "Funksjonalitet ikke implementert");
		}
		else
		{
			System.exit(0);
		}
		
		grenseSnitt();
	
	}
	
	

}
