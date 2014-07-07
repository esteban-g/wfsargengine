/* 
** Author(s): Miguel Calejo
** Contact:   interprolog@declarativa.com, http://www.declarativa.com
** Copyright (C) Declarativa, Portugal, 2000-2002
** Use and distribution, without any warranties, under the terms of the 
** GNU Library General Public License, readable in http://www.fsf.org/copyleft/lgpl.html
*/
package com.declarativa.interprolog.gui;
import com.declarativa.interprolog.*;
import java.io.File;
import java.io.IOException;

/** A ListenerWindowX for a SubprocessEngine. Since Prolog runs as if under a regular OS shell, with standard I/O 
redirected to the ListenerWindowX, this is the best to use during program development. */
public class SubprocessEngineWindow extends ListenerWindow implements PrologOutputListener{
	

    
	public SubprocessEngineWindow(SubprocessEngine e) throws IOException{
		this(e,true);
		setTitle("SubprocessEngine listener ("+e.getPrologVersion()+")");
	}
	public SubprocessEngineWindow(SubprocessEngine e,boolean autoDisplay) throws IOException{
            
            
		super(e,autoDisplay);
		((SubprocessEngine)engine).addPrologOutputListener(this); // so we get output and prompt "events"
	}
	public void sendToProlog(){
               
		String goal = prologInput.getText();
                
            //    prologOutput.append("YOO SI PUEDO!");
                
		prologOutput.append(goal+"\n");
		((SubprocessEngine)engine).sendAndFlushLn(goal);
		focusInput();
		addToHistory();
	}
	
	public void sendCallToProlog(String callToProlog){
               
		String goal = callToProlog;
                
               // System.out.println("SENDI: "+goal);
            //    prologOutput.append("YOO SI PUEDO!");
                
		prologOutput.append(goal+"\n");
		((SubprocessEngine)engine).sendAndFlushLn(goal);
		focusInput();
		addToHistory();
	}        
        
        
	// PrologOutputListener method:
	public void print(String s){
		if (debug) System.out.println("print("+s+")");
		prologOutput.append(s);
		scrollToBottom();
	} 
        
        

        
        
}