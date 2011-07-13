package org.bfc.inventory.gwt.client.activity;

import org.bfc.inventory.gwt.client.factory.ClientFactory;
import org.bfc.inventory.gwt.client.place.AppendInventoryPlace;
import org.bfc.inventory.gwt.client.place.ResetInventoryPlace;
import org.bfc.inventory.gwt.client.view.BfcNavigationView;
import org.bfc.inventory.gwt.client.view.BfcNavigationView.BfcNavigationPresenter;
import org.bfc.inventory.gwt.shared.NavigationListType;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.view.client.SingleSelectionModel;

public abstract class AbstractBfcNavigationActivity extends AbstractActivity implements BfcNavigationPresenter {
	protected ClientFactory clientFactory;
	protected BfcNavigationView bfcNavigationView;

	public AbstractBfcNavigationActivity(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	abstract protected IsWidget getContentsPanelViewWidget();
	abstract protected NavigationListType getViewAnalysisType();
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		bfcNavigationView = this.clientFactory.getBfcNavigationView();
		IsWidget contentsTableWidget = getContentsPanelViewWidget();
		
		SingleSelectionModel<NavigationListType> navSelectionModel = bfcNavigationView.getNavigationPanelSelectionModel();
		if(navSelectionModel != null){
			NavigationListType viewAnalysisType = getViewAnalysisType();
			navSelectionModel.setSelected(viewAnalysisType, true);
		}
		
		bfcNavigationView.setPresenter(this);
		panel.setWidget(bfcNavigationView);
		bfcNavigationView.getContentsTablePanel().setWidget(contentsTableWidget);		
	}

	@Override
	public void handleNavListTypeSelected(NavigationListType analysisType) {
		switch (analysisType) {
		case ResetInventoryParser:
			clientFactory.getPlaceController().goTo(new ResetInventoryPlace());
			break;
		case AppendInventoryParser:
			clientFactory.getPlaceController().goTo(new AppendInventoryPlace());
			break;
		default:
			break;
		}
	}
}
