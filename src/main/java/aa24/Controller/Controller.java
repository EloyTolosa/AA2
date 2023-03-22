package aa24.Controller;

import aa24.Model.Model;
import aa24.View.View;

public class Controller implements Comunicable {

    private View view;
    private Model model;

    public Controller(View view) {
        this.view = view;
    }

    @Override
    public void comunicate(Object... data) {

        if (this.model == null) {
            this.model = new Model(this);
        }

        Action a = (Action) data[0];
        switch (a) {
            case START:
                
                
                Thread t = new Thread(this.model);
                t.start();

                break;

            case CLEAR, ADD_PIECE:

                this.model.comunicate(data);

            case ALERT, PAINT_SOLUTION:

                this.view.comunicate(data);
                break;
        }
    }
    
}
