package com.sap.applicationnorthwind.viewmodel.category;

import android.app.Application;
import android.os.Parcelable;

import com.sap.applicationnorthwind.viewmodel.EntityViewModel;
import com.sap.cloud.android.odata.demoservice.Category;
import com.sap.cloud.android.odata.demoservice.DemoServiceMetadata.EntitySets;

/*
 * Represents View model for Category
 * Having an entity view model for each <T> allows the ViewModelProvider to cache and
 * return the view model of that type. This is because the ViewModelStore of
 * ViewModelProvider cannot not be able to tell the difference between EntityViewModel<type1>
 * and EntityViewModel<type2>.
 */
public class CategoryViewModel extends EntityViewModel<Category> {

    /**
    * Default constructor for a specific view model.
    * @param application - parent application
    */
    public CategoryViewModel(Application application) {
        super(application, EntitySets.categories, Category.name);
    }

    /**
    * Constructor for a specific view model with navigation data.
    * @param application - parent application
    * @param navigationPropertyName - name of the navigation property
    * @param entityData - parent entity (starting point of the navigation)
    */
	 public CategoryViewModel(Application application, String navigationPropertyName, Parcelable entityData) {
        super(application, EntitySets.categories, Category.name, navigationPropertyName, entityData);
    }
}
