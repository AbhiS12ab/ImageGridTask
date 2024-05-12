#Usage

1.Upon launching the app, you'll see a grid of images fetched from the provided API endpoint.

2.You can scroll through the grid to view more images.

3.Images are loaded asynchronously, and caching mechanisms are implemented to improve efficiency.

#Error Handling

1.If there's an error fetching data from the API or loading images, informative error messages will be displayed to the user.

#Evaluation Criteria

1.Images load lazily, and image loading for previous pages is canceled when quickly scrolling to subsequent pages.

2.The image grid scrolls smoothly without any lag.

3.Both disk and memory caching mechanisms are implemented, with the disk cache used if an image is missing in memory cache.


Note
Ensure that your Android Studio is up-to-date to avoid compilation issues.