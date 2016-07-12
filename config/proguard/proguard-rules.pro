# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified

# Application classes that will be serialized/deserialized over Gson and DB models reference
-keep class com.locassa.sampleandroid.model.api.** { *; }
-keep class com.locassa.sampleandroid.model.storage.** { *; }
-keep class com.locassa.sampleandroid.model.db.** { *; }