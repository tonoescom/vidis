package vidis.ui.mvc;

import org.apache.log4j.Logger;

import vidis.ui.events.IVidisEvent;
import vidis.ui.events.VidisEvent;
import vidis.ui.mvc.api.AController;
import vidis.ui.mvc.api.Dispatcher;

public class VidisController extends AController {

	private static Logger logger = Logger.getLogger( VidisController.class );
	
	public VidisController() {
		logger.debug( "Constructor()" );
		addChildController( new InputController() );
		addChildController( new WindowController() );
		addChildController( new SceneController() );
		addChildController( new SimulatorController() );
		
	}
	
	@Override
	public void handleEvent(IVidisEvent event) {
		logger.debug( "handleEvent( "+event+" )" );
		switch ( event.getID() ) {
		case IVidisEvent.Init:
			Dispatcher.forwardEvent( VidisEvent.InitScene );
			Dispatcher.forwardEvent( VidisEvent.InitSimulator );
			break;
		
		}
		forwardEventToChilds( event );
	}

}
