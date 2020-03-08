package view_installation;

import javax.swing.SwingWorker;

public class ProgressWorker extends SwingWorker<Object, Object> {

	@Override
	protected Object doInBackground() throws Exception {
		for (int i = 0; i < 100; i++) {        
            setProgress(i);
            try {
                Thread.sleep(25);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
	}

}
