package com.packtpub.e4.hello.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;

public class SampleHandler extends AbstractHandler { 

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
  		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
  		//window = null;
		MessageDialog.openInformation(
				window.getShell(),
				"hello",
				"bye, Eclipse world");
		return null;
	}
}
